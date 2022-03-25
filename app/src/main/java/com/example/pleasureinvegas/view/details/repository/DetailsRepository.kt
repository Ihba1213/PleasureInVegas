package com.example.pleasureinvegas.view.details.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pleasureinvegas.network.RetrofitClient
import com.example.pleasureinvegas.view.details.model.detail.DetailsModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class DetailsRepository {
    fun getDetails(serviceId: String): LiveData<DetailsModel> {
        val mutableLiveDetailData: MutableLiveData<DetailsModel> = MutableLiveData()
        val call = RetrofitClient().getApiRetrofitInterceptor()?.getDetails(serviceId)
        call?.enqueue(object : Callback, retrofit2.Callback<DetailsModel?> {
            override fun onResponse(call: Call<DetailsModel?>, response: Response<DetailsModel?>) {
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

            override fun onFailure(call: Call<DetailsModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveDetailData

    }
}