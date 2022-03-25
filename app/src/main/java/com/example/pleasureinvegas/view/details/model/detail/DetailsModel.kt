package com.example.pleasureinvegas.view.details.model.detail


import com.example.pleasureinvegas.view.details.model.detail.Data
import com.google.gson.annotations.SerializedName

data class DetailsModel(
    @SerializedName("data")
    val `data`: Data?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("status")
    val status: Int?
)