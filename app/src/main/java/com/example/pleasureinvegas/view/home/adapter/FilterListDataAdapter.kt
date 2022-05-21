package com.example.pleasureinvegas.view.home.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.ListItemRowBinding
import com.example.pleasureinvegas.view.home.model.home.HotelDetail

class FilterListDataAdapter(
    private var itemList: List<HotelDetail>,
) :
    RecyclerView.Adapter<FilterListDataAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: ListItemRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: ListItemRowBinding = itemBinding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: ListItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_row, parent, false
        )
        return ViewHolder(itemBinding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvHotelName.text = itemList[position].hotelName
            tvHotelName.setOnClickListener {

            }

            }
        }

    override fun getItemCount(): Int {
        return itemList.size
    }




}
