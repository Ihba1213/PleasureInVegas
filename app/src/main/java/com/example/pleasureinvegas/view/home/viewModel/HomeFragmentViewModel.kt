package com.example.pleasureinvegas.view.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pleasureinvegas.view.home.model.home.HomeItemAddedModel
import com.example.pleasureinvegas.view.home.repository.HomeRepository

class HomeFragmentViewModel : ViewModel() {
    fun getHomeItemList(): LiveData<HomeItemAddedModel> = HomeRepository().getHomeData()
}