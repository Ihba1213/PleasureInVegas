package com.example.pleasureinvegas.view.home.adapter

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.core.utils.Constants
import com.example.pleasureinvegas.databinding.HomeItemBinidngBinding
import com.example.pleasureinvegas.view.home.model.home.Data

class HomeItemAdapter(
    private val requireActivity: FragmentActivity,
    private val itemList: MutableList<Data>,
) :
    RecyclerView.Adapter<HomeItemAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: HomeItemBinidngBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: HomeItemBinidngBinding = itemBinding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: HomeItemBinidngBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.home_item_binidng, parent, false
        )
        return ViewHolder(itemBinding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvHeading.text = itemList[position].name
            Glide
                .with(requireActivity)
                .load(Constants.imgBaseUrl + itemList[position].image)
                .centerCrop()
                .placeholder(R.drawable.dummyone)
                .into(ivItem)
            containerThree.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("item_type", itemList[position].id)
                Navigation.findNavController(holder.binding.root)
                    .navigate(R.id.action_homeFragment_to_menuFragment, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}