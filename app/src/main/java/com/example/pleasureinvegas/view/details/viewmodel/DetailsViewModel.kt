package com.example.pleasureinvegas.view.details.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pleasureinvegas.view.details.model.detail.DetailsModel
import com.example.pleasureinvegas.view.details.repository.DetailsRepository

class DetailsViewModel : ViewModel() {
    fun getDetails(serviceId : String) : LiveData<DetailsModel> = DetailsRepository().getDetails(serviceId)
}