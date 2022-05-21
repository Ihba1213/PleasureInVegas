package com.example.pleasureinvegas.view.home


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.core.utils.Constants
import com.example.pleasureinvegas.databinding.FragmentHomeBinding
import com.example.pleasureinvegas.view.home.adapter.FilterListDataAdapter
import com.example.pleasureinvegas.view.home.adapter.HomeItemAdapter
import com.example.pleasureinvegas.view.home.model.home.Data
import com.example.pleasureinvegas.view.home.model.home.HotelDetail
import com.example.pleasureinvegas.view.home.viewModel.HomeFragmentViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeFragmentViewModel
    private var dataList: ArrayList<Data> = ArrayList()
    private var filterAdapter: FilterListDataAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.containerTwo.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("item_type", dataList[0].id)
            findNavController().navigate(R.id.action_homeFragment_to_menuFragment, bundle)
        }
        showLoading()
        getHomeData()
        searchTextWatcher()
        initalizedRv()
    }

    private fun initalizedRv() {
        binding.rvFilter.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext())
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
            adapter = FilterListDataAdapter(listOf())
        }
    }

    private fun searchTextWatcher() {
        binding.edtSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

                // TODO Auto-generated method stub
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {
                //you can use runnable postDelayed like 500 ms to delay search text
                if (s.isNotEmpty()) binding.rvFilter.visibility = View.VISIBLE
                else binding.rvFilter.visibility = View.GONE
                filtersData(s.toString())

            }
        })
    }

    private fun filtersData(text: String) {
        viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        viewModel.getHotelList().observe(viewLifecycleOwner) {
            filterItem(it, text)
        }
    }

    private fun filterItem(filteredItem: List<HotelDetail>, text: String) {
        val temp: MutableList<HotelDetail> = ArrayList()
        for (item in filteredItem) {
            if (item.hotelName.contains(text)) {
                temp.add(item)
            }
        }
        binding.rvFilter.adapter = FilterListDataAdapter(temp)
    }



    private fun showLoading() {
        binding.shimmerViewContainer.visibility = View.VISIBLE
        binding.containerMain.visibility = View.GONE
        binding.shimmerViewContainer.startShimmer()
    }

    private fun getHomeData() {
        viewModel = ViewModelProvider(this)[HomeFragmentViewModel::class.java]
        viewModel.getHomeItemList().observe(viewLifecycleOwner) {
            if (it.status == 1) {
                hideLoading()
                binding.tvFood.text = it.data?.get(0)?.name
                Glide
                    .with(requireContext())
                    .load(Constants.imgBaseUrl + it.data?.get(0)?.image)
                    .centerCrop()
                    .placeholder(R.drawable.dummyone)
                    .into(binding.ivFood)
                dataList.addAll(it.data!!)
                setDataInAdapter(dataList)
            }
        }
    }

    private fun hideLoading() {
        binding.shimmerViewContainer.visibility = View.GONE
        binding.containerMain.visibility = View.VISIBLE
        binding.shimmerViewContainer.stopShimmer()
    }

    private fun setDataInAdapter(dataList: ArrayList<Data>) {
        binding.rvHomeItem.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(requireContext(), 2)
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
            adapter = HomeItemAdapter(requireActivity(), dataList.subList(1, dataList.size))
        }
    }


}