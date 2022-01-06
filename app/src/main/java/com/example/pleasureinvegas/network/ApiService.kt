package com.example.pleasureinvegas.network

import com.example.pleasureinvegas.view.home.model.DetailModel
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
}