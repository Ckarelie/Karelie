package com.karelie.mvvmdemo.di

import com.karelie.commom.support.StateLiveData
import com.karelie.mvvmdemo.base.BaseViewModel
import com.karelie.mvvmdemo.bean.main.MainData
import com.karelie.mvvmdemo.bean.main.MainRepository

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