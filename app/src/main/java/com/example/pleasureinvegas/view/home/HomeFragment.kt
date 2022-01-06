package com.example.pleasureinvegas.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.FragmentHomeBinding
import com.example.pleasureinvegas.network.SharedViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        viewModel = ViewModelProvider(this)[SharedViewModel::class.java]
        binding.containerTwo.setOnClickListener {
            viewModel.postDetailApi("1").observe(viewLifecycleOwner, {
                if (it.status == 1) {
                    val bundle = Bundle()
                    bundle.putString("KeyName", it.data!![0]?.menuName)
                    findNavController().navigate(R.id.action_homeFragment_to_dealsFragment,
                        bundle)
                }
            })
        }
    }


}