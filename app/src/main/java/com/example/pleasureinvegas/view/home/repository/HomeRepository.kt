package com.example.pleasureinvegas.view.home.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pleasureinvegas.network.RetrofitClient
import com.example.pleasureinvegas.view.home.model.home.HomeItemAddedModel
import com.example.pleasureinvegas.view.home.model.home.HotelDetail
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

    fun getHotelData(): LiveData<List<HotelDetail>> {
        val mutableLiveHotelDetailData: MutableLiveData<List<HotelDetail>> = MutableLiveData()
        val hotelDetailDataList = ArrayList<HotelDetail>()
        hotelDetailDataList.add(HotelDetail("Kiev", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Bangkok", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Chiang Mai", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Chiang Saen", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Hua Hin", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Koh Samui", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Pattaya Cholburi", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Caracas", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Maracaibo", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Estoril", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Funchal", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Lisbon", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Porto", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Guanacaste", "CY3546"))
        hotelDetailDataList.add(HotelDetail("San Jose", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Tamarindo", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Amargosa Valley", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Boulder City", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Carson City", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Elko", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Fallon", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Henderson", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Incline Village", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Jean", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Las Vegas", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Laughlin", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Mesquite", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Mount Charleston", "CY3546"))
        hotelDetailDataList.add(HotelDetail("North Las Vegas", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Primm", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Reno", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Sparks", "CY3546"))
        hotelDetailDataList.add(HotelDetail("Stateline", "CY3546"))
        mutableLiveHotelDetailData.postValue(hotelDetailDataList)

        return mutableLiveHotelDetailData


    }
}