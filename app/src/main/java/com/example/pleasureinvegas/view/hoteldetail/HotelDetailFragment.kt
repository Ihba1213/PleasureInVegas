package com.example.pleasureinvegas.view.hoteldetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pleasureinvegas.R

class HotelDetailFragment : Fragment() {
    private lateinit var viewModel: HotelViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    @SuppressLint("MissingSuperCall")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory())[HotelViewModel::class.java]
        // TODO: Use the ViewModel
    }

}