package com.example.pleasureinvegas.view.hoteldetail.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pleasureinvegas.databinding.BlankFragmentBinding
import com.example.pleasureinvegas.view.hoteldetail.model.HotelItemModel
import com.example.pleasureinvegas.view.hoteldetail.viewmodel.HotelViewModel
import com.example.pleasureinvegas.view.hoteldetail.adapter.HotelDetailAdapter

class HotelDetailFragment : Fragment() {
    private var _binding: BlankFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: HotelViewModel
    private val hotelDetailAdapter by lazy { HotelDetailAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = BlankFragmentBinding.inflate(inflater, container, false)
        binding.rvHomeItem.layoutManager = LinearLayoutManager(requireContext())
        binding.rvHomeItem.adapter = hotelDetailAdapter

        val hotelOne = HotelItemModel(
            "1",
            "City Queen/Queen",
            "$50 Food and bev Credit Per Stay w/2 NT Min Stay",
            "2 Adults | 1 Child",
            "2 child only allowed",
            "$193.01",
            "593.04")

        val hotelTwo = HotelItemModel(
            "1",
            "City Queen/Queen",
            "$50 Food and bev Credit Per Stay w/2 NT Min Stay",
            "2 Adults | 1 Child",
            "2 child only allowed",
            "$193.01",
            "593.04")

        val hotelThree = HotelItemModel(
            "1",
            "City Queen/Queen",
            "$50 Food and bev Credit Per Stay w/2 NT Min Stay",
            "2 Adults | 1 Child",
            "2 child only allowed",
            "$193.01",
            "593.04")

        val hotelFour = HotelItemModel(
            "1",
            "City Queen/Queen",
            "$50 Food and bev Credit Per Stay w/2 NT Min Stay",
            "2 Adults | 1 Child",
            "2 child only allowed",
            "$193.01",
            "593.04")
        hotelDetailAdapter.setData(listOf(hotelOne, hotelTwo, hotelThree, hotelFour))

        return binding.root
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[HotelViewModel::class.java]
        // TODO: Use the ViewModel
    }

}