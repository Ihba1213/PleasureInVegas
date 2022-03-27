package com.example.pleasureinvegas.view.hoteldetail.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.pleasureinvegas.view.hoteldetail.model.HotelItemModel

class HotelDetailDiffUtil(
    private val oldList : List<HotelItemModel>,
    private val newList : List<HotelItemModel>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
       return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
       return when {
           oldList[oldItemPosition].id != newList[newItemPosition].id -> {
               false
           }
           oldList[oldItemPosition].hotelName != newList[newItemPosition].hotelName -> {
               false
           }
           oldList[oldItemPosition].hotelDesc != newList[newItemPosition].hotelDesc -> {
               false
           }
           oldList[oldItemPosition].avgNightLabelAmount != newList[newItemPosition].avgNightLabelAmount -> {
               false
           }
           oldList[oldItemPosition].personAvail != newList[newItemPosition].personAvail -> {
               false
           }
           oldList[oldItemPosition].personChildLimit != newList[newItemPosition].personChildLimit -> {
               false
           }
           else -> true
       }
    }
}