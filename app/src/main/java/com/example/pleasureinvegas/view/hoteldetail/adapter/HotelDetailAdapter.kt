package com.example.pleasureinvegas.view.hoteldetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pleasureinvegas.databinding.HotelListBinding
import com.example.pleasureinvegas.view.hoteldetail.model.HotelItemModel

class HotelDetailAdapter : RecyclerView.Adapter<HotelDetailAdapter.MyViewHolder>() {
    private var oldHotelItemList = emptyList<HotelItemModel>()
    class MyViewHolder(val binding: HotelListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(HotelListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.tvHotelName
    }

    override fun getItemCount(): Int {
       return  oldHotelItemList.size
    }

    fun setData(newHotelList : List<HotelItemModel>){
        val diffUtil = HotelDetailDiffUtil(oldHotelItemList,newHotelList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        oldHotelItemList = newHotelList
        diffResult.dispatchUpdatesTo(this)
    }

}