package com.example.pleasureinvegas.view.menudetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.FragmentMenuBinding
import com.example.pleasureinvegas.view.menudetails.adapter.MenuItemAdapter
import com.example.pleasureinvegas.view.menudetails.adapter.MenuListAdapter
import com.example.pleasureinvegas.view.menudetails.model.DetailModel
import com.example.pleasureinvegas.view.menudetails.model.detail.Data
import com.example.pleasureinvegas.view.menudetails.viewmodel.MenuFragmentViewModel

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuFragmentViewModel
    private var dataList: ArrayList<DetailModel.Data> = ArrayList()
    private var menuListDetails: ArrayList<Data> = ArrayList()
    private var key: String? = ""
    private var menuItemAdapter: MenuItemAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_menu, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.apply {
            key = arguments?.getString("item_type") ?: "0"
        }
        initView()
    }

    private fun initView() {
        showLoading()
        viewModel = ViewModelProvider(this)[MenuFragmentViewModel::class.java]
        viewModel.postMenuApi(key!!).observe(viewLifecycleOwner, {
            if (it.status == 1) {
                hideLoading()
                for (i in it.data!!) {
                    dataList.add(i!!)
                }
                if (dataList.size > 0) {
                    binding.rvMenuItemDetails.visibility = View.VISIBLE
                    binding.noRecordFound.visibility = View.GONE
                    menuItemClicked(dataList[0])
                    setDataMenuItem(dataList)
                } else {
                    binding.rvMenuItemDetails.visibility = View.GONE
                    binding.noRecordFound.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "No Records Found!!", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        })
    }

    private fun showLoading() {
        binding.shimmerViewContainer.visibility = View.VISIBLE
        binding.rvMenuItemDetails.visibility = View.GONE
        binding.shimmerViewContainer.startShimmer()
    }

    private fun hideLoading() {
        binding.shimmerViewContainer.visibility = View.GONE
        binding.rvMenuItemDetails.visibility = View.VISIBLE
        binding.shimmerViewContainer.stopShimmer()
    }

    private fun setDataMenuItem(dataList: ArrayList<DetailModel.Data>) {
        binding.rvMenuItem.apply {
            setHasFixedSize(true)
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
            menuItemAdapter =
                MenuItemAdapter(requireActivity(), dataList) { data: DetailModel.Data ->
                    menuItemClicked(data)
                }
            adapter = menuItemAdapter
        }
    }

    private fun menuItemClicked(data: DetailModel.Data) {
        showLoading()
        menuListDetails.clear()
        if (data.menuId != null && data.parentId != null) {
            viewModel.postMenuDetailApi(data.menuId, data.parentId).observe(viewLifecycleOwner, {
                if (it.status == 1) {
                    hideLoading()
                    binding.rvMenuItemDetails.visibility = View.VISIBLE
                    binding.noRecordFound.visibility = View.GONE
                    menuListDetails.addAll(it.data!!)
                    binding.rvMenuItemDetails.apply {
                        setHasFixedSize(true)
                        layoutManager =
                            LinearLayoutManager(requireContext(),
                                LinearLayoutManager.VERTICAL,
                                false)
                        itemAnimator = DefaultItemAnimator()
                        isNestedScrollingEnabled = false
                        adapter = MenuListAdapter(requireActivity(), menuListDetails)
                    }
                } else {
                    hideLoading()
                    binding.rvMenuItemDetails.visibility = View.GONE
                    binding.noRecordFound.visibility = View.VISIBLE
                    Toast.makeText(requireContext(), "No Records Found!!", Toast.LENGTH_SHORT)
                        .show()
                }

            })
        } else {
            hideLoading()
            Toast.makeText(requireContext(), "No Records Found!!", Toast.LENGTH_SHORT).show()
        }
    }


}