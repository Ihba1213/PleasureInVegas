package com.example.pleasureinvegas.view.details

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.core.utils.Constants
import com.example.pleasureinvegas.databinding.FragmentDetailsFragmentsBinding

import com.example.pleasureinvegas.view.details.adapter.DetailMenuAdapter
import com.example.pleasureinvegas.view.details.adapter.DetailSubServiceAdapter
import com.example.pleasureinvegas.view.details.model.detail.SubService
import com.example.pleasureinvegas.view.details.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_details_fragments.*


class DetailsFragments : Fragment() {

    private lateinit var binding: FragmentDetailsFragmentsBinding
    private lateinit var viewModel: DetailsViewModel
    private var itemList: ArrayList<SubService> = ArrayList()
    private var serviceId: String? = ""
    private var urlTitle: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_details_fragments, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.apply {
            serviceId = arguments?.getString("service_id") ?: "0"
            urlTitle = arguments?.getString("url_title") ?: ""
        }
        initView()
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    private fun initView() {
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        viewModel.getDetails(serviceId!!).observe(viewLifecycleOwner, {
            if (it.status == 1) {
                itemList.addAll(it.data?.subServices!!)
                binding.apply {
                    if (it != null) {
                        tv_first_heading_title.text = it.data.serviceDetail?.name
                        tv_first_heading_company_name.text = it.data.serviceDetail?.description
                        tv_desc.text = it.data.serviceDetail?.aboutUs
                        if (it.data.menus?.size!! > 0)
                            menuName.text = it.data.menus[0].menuName ?: ""
                        mobileNumber.text = it.data.serviceDetail?.phone
                        imgTv.text = it.data.serviceDetail?.menuName
                        Glide
                            .with(requireContext())
                            .load(Constants.imgBaseUrl + urlTitle)
                            .centerCrop()
                            .placeholder(R.drawable.dummyone)
                            .into(ivDetailIcon)
                        ivTimeGiven.text =
                            it.data.serviceDetail?.openFrom + " : " + it.data.serviceDetail?.closedAt
                        rvSubService.apply {
                            setHasFixedSize(true)
                            layoutManager =
                                LinearLayoutManager(requireContext(),
                                    LinearLayoutManager.HORIZONTAL,
                                    false)
                            itemAnimator = DefaultItemAnimator()
                            isNestedScrollingEnabled = false
                            adapter = DetailSubServiceAdapter(it.data.subServices)
                        }
                        rvSubServiceDetails.apply {
                            setHasFixedSize(true)
                            layoutManager =
                                LinearLayoutManager(requireContext(),
                                    LinearLayoutManager.HORIZONTAL,
                                    false)
                            itemAnimator = DefaultItemAnimator()
                            isNestedScrollingEnabled = false
                            adapter = DetailMenuAdapter(requireActivity(), it.data.menus)
                        }
                    }
                }
            }
        })
        binding.makeBooking.setOnClickListener {
            findNavController().navigate(R.id.action_detailsFragments_to_makeReservationFragment)
        }
    }


}