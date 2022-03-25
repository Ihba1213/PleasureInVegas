package com.example.pleasureinvegas.view.menudetails.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.ItemMenuRowBinding
import com.example.pleasureinvegas.view.menudetails.model.DetailModel

class MenuItemAdapter(
    private val requireContext: Context,
    private val dataList: ArrayList<DetailModel.Data>,
    private val clickListener: (DetailModel.Data) -> Unit,
) : RecyclerView.Adapter<MenuItemAdapter.ViewHolder>() {
    private var selectedPosition = 0

    class ViewHolder(itemBinding: ItemMenuRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: ItemMenuRowBinding = itemBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: ItemMenuRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_menu_row, parent, false
        )
        return ViewHolder(itemBinding)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.apply {
            tvHeading.setBackgroundColor(
                if (selectedPosition == position) {
                    requireContext.getColor(R.color.yello)
                } else requireContext.getColor(R.color.tv_background_color)
            )
            tvHeading.setTextColor(
                if (selectedPosition == position) {
                    requireContext.getColor(R.color.black)
                } else requireContext.getColor(R.color.white)
            )
            tvHeading.text = dataList[position].menuName
            container.setOnClickListener {
                notifyItemChanged(selectedPosition)
                selectedPosition = position
                notifyItemChanged(selectedPosition)
                clickListener(dataList[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}