package com.example.pleasureinvegas.view.menudetails.model.detail


import com.google.gson.annotations.SerializedName

data class DetailPostDetailModel(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("status")
    val status: Int?
)