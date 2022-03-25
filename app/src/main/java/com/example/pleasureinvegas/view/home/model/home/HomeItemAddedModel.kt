package com.example.pleasureinvegas.view.home.model.home


import com.google.gson.annotations.SerializedName

data class HomeItemAddedModel(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("status")
    val status: Int?,
)