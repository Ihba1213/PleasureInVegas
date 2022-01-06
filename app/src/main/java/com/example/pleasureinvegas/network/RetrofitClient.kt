package com.example.pleasureinvegas.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    private var retrofit: Retrofit? = null
    private var BASE_URL = "https://pleasureinvegas.com/"

    private var okHttpInterceptor = OkHttpClient().newBuilder()
        .connectTimeout(120, TimeUnit.MINUTES)
        .readTimeout(120, TimeUnit.MINUTES)
        .writeTimeout(120, TimeUnit.MINUTES)
        .build()


    fun getApiRetrofitInterceptor(): ApiService? {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(okHttpInterceptor)
            .build()
        return retrofit!!.create(ApiService::class.java)
    }

}