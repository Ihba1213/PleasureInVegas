package com.example.pleasureinvegas.view.hoteldetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.view.hoteldetail.viewmodel.AllHotelDetailsViewModel

class AllHotelDetailsFragment : Fragment() {

    private lateinit var viewModel: AllHotelDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.all_hotel_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            AllHotelDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}