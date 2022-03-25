package com.example.pleasureinvegas.view.home.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pleasureinvegas.network.RetrofitClient
import com.example.pleasureinvegas.view.home.model.home.HomeItemAddedModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class HomeRepository {
    fun getHomeData(): LiveData<HomeItemAddedModel> {
        val mutableLiveDetailData: MutableLiveData<HomeItemAddedModel> = MutableLiveData()
        val call = RetrofitClient().getApiRetrofitInterceptor()?.getHomeData()
        call?.enqueue(object : Callback, retrofit2.Callback<HomeItemAddedModel?> {
            override fun onResponse(
                call: Call<HomeItemAddedModel?>,
                response: Response<HomeItemAddedModel?>,
            ) {
                try {
                    if (response.isSuccessful) {
                        mutableLiveDetailData.postValue(response.body())
                    } else {
                        mutableLiveDetailData.postValue(null)
                    }
                } catch (e: Exception) {
                    mutableLiveDetailData.postValue(null)
                }
            }

            override fun onFailure(call: Call<HomeItemAddedModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveDetailData
    }
}