package com.example.pleasureinvegas.view.home.model.home


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("created")
    val created: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("url_title")
    val urlTitle: Any?
)