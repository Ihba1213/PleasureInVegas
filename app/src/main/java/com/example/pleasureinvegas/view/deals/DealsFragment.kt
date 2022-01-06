package com.example.pleasureinvegas.view.deals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.FragmentDealsBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DealsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DealsFragment : Fragment() {

    private lateinit var binding: FragmentDealsBinding
    private var menuName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        arguments.apply {
            menuName = this?.getString("KeyName") ?: ""
        }
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_deals, container, false)
        binding.tvName.text = menuName
        return binding.root
    }


}