package com.example.pleasureinvegas.view.details.model.detail


import com.google.gson.annotations.SerializedName

data class Menu(
    @SerializedName("created")
    val created: String?,
    @SerializedName("created_by")
    val createdBy: String?,
    @SerializedName("menu_desc")
    val menuDesc: String?,
    @SerializedName("menu_id")
    val menuId: String?,
    @SerializedName("menu_name")
    val menuName: String?,
    @SerializedName("parent_id")
    val parentId: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("updated_by")
    val updatedBy: String?,
    @SerializedName("url_title")
    val urlTitle: String?
)