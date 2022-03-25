package com.example.pleasureinvegas.view.menudetails.adapter

import android.annotation.SuppressLint
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
import com.example.pleasureinvegas.databinding.MenuItemDetailBinding
import com.example.pleasureinvegas.view.menudetails.model.detail.Data

class MenuListAdapter(
    private val requireActivity: FragmentActivity,
    private val dataList: ArrayList<Data>,
) : RecyclerView.Adapter<MenuListAdapter.ViewHolder>() {
    class ViewHolder(itemBinding: MenuItemDetailBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: MenuItemDetailBinding = itemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: MenuItemDetailBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.menu_item_detail, parent, false
        )
        return ViewHolder(itemBinding)
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvTopHeading.text = dataList[position].name
            tvSubHeading.text = dataList[position].aboutUs
            headingAmount.text = dataList[position].openFrom + ": " + dataList[position].closedAt
            Glide
                .with(requireActivity)
                .load(Constants.imgBaseUrl + dataList[position].image)
                .centerCrop()
                .placeholder(R.drawable.dummyone)
                .into(ivContainer)
            amount.text = "$" + dataList[position].startingPrice
            clickButton.text = dataList[position].address
            container.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("service_id", dataList[position].id)
                bundle.putString("url_title", dataList[position].image)
                Navigation.findNavController(root)
                    .navigate(R.id.action_menuFragment_to_detailsFragments, bundle)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}