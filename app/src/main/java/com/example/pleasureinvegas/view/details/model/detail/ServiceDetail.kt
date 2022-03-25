package com.example.pleasureinvegas.view.details.model.detail


import com.google.gson.annotations.SerializedName

data class ServiceDetail(
    @SerializedName("about_us")
    val aboutUs: String?,
    @SerializedName("address")
    val address: String?,
    @SerializedName("closed_at")
    val closedAt: String?,
    @SerializedName("created")
    val created: String?,
    @SerializedName("created_by")
    val createdBy: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("facebook")
    val facebook: Any?,
    @SerializedName("health_rating")
    val healthRating: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("instagram")
    val instagram: Any?,
    @SerializedName("is_offer")
    val isOffer: String?,
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lng")
    val lng: String?,
    @SerializedName("menu_id")
    val menuId: String?,
    @SerializedName("menu_name")
    val menuName: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("open_from")
    val openFrom: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("pinterest")
    val pinterest: Any?,
    @SerializedName("reservation_option")
    val reservationOption: Any?,
    @SerializedName("starting_price")
    val startingPrice: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("twitter")
    val twitter: Any?,
    @SerializedName("updated")
    val updated: String?,
    @SerializedName("updated_by")
    val updatedBy: String?
)