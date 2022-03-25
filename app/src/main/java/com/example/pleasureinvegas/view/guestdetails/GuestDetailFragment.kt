package com.example.pleasureinvegas.view.guestdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pleasureinvegas.R

class GuestDetailFragment : Fragment() {

    companion object {
        fun newInstance() = GuestDetailFragment()
    }

    private lateinit var viewModel: GuestDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.guest_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this,
            ViewModelProvider.NewInstanceFactory()).get(GuestDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}