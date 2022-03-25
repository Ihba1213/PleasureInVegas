package com.example.pleasureinvegas.view.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.core.utils.Constants
import com.example.pleasureinvegas.databinding.DetailItemCardBinding
import com.example.pleasureinvegas.view.details.model.detail.Menu

class DetailMenuAdapter(
    private val requireActivity: FragmentActivity,
    private val menus: List<Menu>,
) :
    RecyclerView.Adapter<DetailMenuAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: DetailItemCardBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: DetailItemCardBinding = itemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: DetailItemCardBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.detail_item_card, parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvTopHeading.text = menus[position].menuName ?: ""
        holder.binding.tvSubHeading.text = menus[position].menuDesc ?: ""
        holder.binding.clickButton.text = menus[position].menuId ?: ""
        Glide
            .with(requireActivity)
            .load(Constants.imgBaseUrl + menus[position].urlTitle)
            .centerCrop()
            .placeholder(R.drawable.dummyone)
            .into(holder.binding.ivMenu)
    }

    override fun getItemCount(): Int {
        return menus.size
    }
}