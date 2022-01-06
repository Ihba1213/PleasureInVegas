package com.example.pleasureinvegas.model
import com.google.gson.annotations.SerializedName

data class DetailModel(
    @SerializedName("data")
    val `data`: List<Data?>?,
    @SerializedName("msg")
    val msg: String?,
    @SerializedName("status")
    val status: Int?
) {
    data class Data(
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
        @SerializedName("sub_menu")
        val subMenu: List<Any?>?,
        @SerializedName("updated")
        val updated: String?,
        @SerializedName("updated_by")
        val updatedBy: String?,
        @SerializedName("url_title")
        val urlTitle: String?
    )
}