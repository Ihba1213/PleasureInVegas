package com.example.pleasureinvegas.network

import com.example.pleasureinvegas.view.details.model.detail.DetailsModel
import com.example.pleasureinvegas.view.home.model.home.HomeItemAddedModel
import com.example.pleasureinvegas.view.menudetails.model.DetailModel
import com.example.pleasureinvegas.view.menudetails.model.detail.DetailPostDetailModel
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("api/menu/get_menu")
    fun postDetail(@Field("id") id: String?): Call<DetailModel?>?

    @FormUrlEncoded
    @GET("auth/user_register")
    fun registrUser(@Field("mobile") Phone: String?): Call<String?>?

    @GET("/api/menu/get_main_menu")
    fun getHomeData(): Call<HomeItemAddedModel>

    @FormUrlEncoded
    @POST("api/services/get_services")
    fun postMenuDetails(
        @Field("menu_id") menuId: String, @Field("mani_menu_id") mainMenuId: String,
    ): Call<DetailPostDetailModel>

    @FormUrlEncoded
    @POST("api/services/get_sub_services")
    fun getDetails(@Field("service_id") serviceId: String): Call<DetailsModel>
}