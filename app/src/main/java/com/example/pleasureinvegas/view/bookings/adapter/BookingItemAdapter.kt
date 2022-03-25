package com.example.pleasureinvegas.view.bookings.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.BookingItemRowBinding
import com.example.pleasureinvegas.view.bookings.model.BokingModel

class BookingItemAdapter(
    private val requireActivity: FragmentActivity,
    private val itemList: ArrayList<BokingModel>,
) :
    RecyclerView.Adapter<BookingItemAdapter.ViewHolder>() {

    class ViewHolder(itemBinding: BookingItemRowBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        val binding: BookingItemRowBinding = itemBinding

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: BookingItemRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.booking_item_row, parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = itemList[position].title
            tvCompanyName.text = itemList[position].companyName
            tvTime.text = itemList[position].time
            date.text = itemList[position].date
            name.text = itemList[position].name
            email.text = itemList[position].email
            phNumber.text = itemList[position].phone
            viewDetails.setOnClickListener {

            }
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}