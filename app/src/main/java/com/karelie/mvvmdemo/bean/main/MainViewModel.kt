package com.karelie.mvvmdemo.bean.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karelie.commom.support.StateLiveData
import com.karelie.mvvmdemo.base.BaseViewModel
import retrofit2.Retrofit

class MainViewModel : BaseViewModel() {
    private val repository by lazy { MainRepository() }
    val userLiveData = StateLiveData<MainData?>()

    fun login(username : String , password : String) {
        launchWithLoading(requestBlock = {
            repository.login(username,password)
        },resultCallback = {
            userLiveData.value = it
        })
    }

}