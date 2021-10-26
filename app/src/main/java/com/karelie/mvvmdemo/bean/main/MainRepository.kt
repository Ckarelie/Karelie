package com.karelie.mvvmdemo.bean.main

import com.karelie.commom.net.BaseRepository
import com.karelie.commom.net.BaseResp
import com.karelie.mvvmdemo.net.RetrofitClient

class MainRepository : BaseRepository() {
    private val mService by lazy {
        RetrofitClient.service
    }
    suspend fun login(username : String,password : String) : BaseResp<MainData?>{
        return executeHttp {
            mService.login(username,password)
        }
    }
}