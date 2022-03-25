package com.example.pleasureinvegas.view.menudetails.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pleasureinvegas.network.RetrofitClient
import com.example.pleasureinvegas.view.menudetails.model.DetailModel
import com.example.pleasureinvegas.view.menudetails.model.detail.DetailPostDetailModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MenuRepository {
    fun postMenuApi(id: String): LiveData<DetailModel> {
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

    fun postMenuDetailApi(menuId : String, mainMenuId : String): LiveData<DetailPostDetailModel> {
        val mutableLiveMenuDetailData : MutableLiveData<DetailPostDetailModel> = MutableLiveData()
        val call = RetrofitClient().getApiRetrofitInterceptor()?.postMenuDetails(menuId, mainMenuId)
        call?.enqueue(object : Callback, retrofit2.Callback<DetailPostDetailModel?> {
            override fun onResponse(call: Call<DetailPostDetailModel?>, response: Response<DetailPostDetailModel?>) {
                try {
                    if (response.isSuccessful) {
                        mutableLiveMenuDetailData.postValue(response.body())
                    } else {
                        mutableLiveMenuDetailData.postValue(null)
                    }
                } catch (e: Exception) {
                    mutableLiveMenuDetailData.postValue(null)
                }
            }

            override fun onFailure(call: Call<DetailPostDetailModel?>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return mutableLiveMenuDetailData
    }
}