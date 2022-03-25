package com.example.pleasureinvegas.view.bookings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.FragmentBookingBinding
import com.example.pleasureinvegas.view.bookings.adapter.BookingItemAdapter
import com.example.pleasureinvegas.view.bookings.model.BokingModel
import com.example.pleasureinvegas.view.home.adapter.HomeItemAdapter

class BookingFragment : Fragment() {

    private lateinit var binding: FragmentBookingBinding
    private lateinit var dataList : ArrayList<BokingModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_booking, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        dataList = ArrayList()
        val item = BokingModel("OSAKA",
            "Osaka Japanese Bistro",
            "15 Dec 2021",
            "Prakhar",
            "prkah123@gmail.com",
            "9599525080", "08:00 PM")
        dataList.add(item)
        dataList.add(item)

        binding.rvBookingAddress.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
            itemAnimator = DefaultItemAnimator()
            isNestedScrollingEnabled = false
            adapter = BookingItemAdapter(requireActivity(), dataList)
        }
    }


}