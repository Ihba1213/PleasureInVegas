package com.example.pleasureinvegas.view.details.model.detail


import com.google.gson.annotations.SerializedName

data class SubService(
    @SerializedName("created")
    val created: String?,
    @SerializedName("created_by")
    val createdBy: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("menu_id")
    val menuId: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("price")
    val price: String?,
    @SerializedName("service_id")
    val serviceId: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("sub_menu_id")
    val subMenuId: Any?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("updated")
    val updated: Any?,
    @SerializedName("updated_by")
    val updatedBy: Any?,
)