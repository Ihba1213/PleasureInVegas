package com.example.pleasureinvegas.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pleasureinvegas.model.DetailModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class RetrofitHit {

    fun postDetailApi(id: String): LiveData<DetailModel> {
        val mutableLiveDetailData: MutableLiveData<DetailModel> = MutableLiveData()
        val call = RetrofitClient().getApiRetrofitInterceptor()?.postDetail(id)
        call?.enqueue(object : Callback, retrofit2.Callback<DetailModel?> {
            override fun onResponse(call: Call<DetailModel?>, response: Response<DetailModel?>) {
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

            override fun onFailure(call: Call<DetailModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveDetailData
    }

}