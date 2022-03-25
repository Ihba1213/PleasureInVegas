package com.example.pleasureinvegas.view.menudetails.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.pleasureinvegas.view.menudetails.model.DetailModel
import com.example.pleasureinvegas.view.menudetails.model.detail.DetailPostDetailModel
import com.example.pleasureinvegas.view.menudetails.repository.MenuRepository

class MenuFragmentViewModel : ViewModel() {
    fun postMenuApi(id: String): LiveData<DetailModel> = MenuRepository().postMenuApi(id)
    fun postMenuDetailApi(menuId: String, mainMenuId: String): LiveData<DetailPostDetailModel> =
        MenuRepository().postMenuDetailApi(menuId, mainMenuId)
}