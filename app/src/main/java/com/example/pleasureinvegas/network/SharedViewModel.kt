package com.example.pleasureinvegas.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pleasureinvegas.view.home.model.DetailModel

class SharedViewModel : ViewModel() {

    fun postDetailApi(id: String): LiveData<DetailModel> {
        return RetrofitHit().postDetailApi(id)
    }

}