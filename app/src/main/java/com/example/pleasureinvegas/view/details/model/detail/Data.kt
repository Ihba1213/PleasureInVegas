package com.example.pleasureinvegas.view.details.model.detail


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("menus")
    val menus: List<Menu>?,
    @SerializedName("service_detail")
    val serviceDetail: ServiceDetail?,
    @SerializedName("sub_services")
    val subServices: List<SubService>?
)