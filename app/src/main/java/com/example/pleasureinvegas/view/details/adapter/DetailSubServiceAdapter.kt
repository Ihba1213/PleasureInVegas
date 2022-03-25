package com.example.pleasureinvegas.view.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.core.utils.Constants
import com.example.pleasureinvegas.databinding.MenuItemBinding
import com.example.pleasureinvegas.view.details.model.detail.SubService

class DetailSubServiceAdapter(private val menus: List<SubService>) :
    RecyclerView.Adapter<DetailSubServiceAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: MenuItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: MenuItemBinding = itemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: MenuItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.menu_item, parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvSubServices.text = menus[position].type ?: ""

    }

    override fun getItemCount(): Int {
        return menus.size
    }
}