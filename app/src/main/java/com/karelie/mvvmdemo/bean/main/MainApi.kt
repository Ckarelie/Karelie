package com.karelie.mvvmdemo.bean.main

import com.karelie.commom.net.BaseResp
import com.karelie.service.main.MainDB
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MainApi {
    /**
     * @Creator:Karelie
     * @Data: 2021/10/21
     * @TIME: 10:14
     * @Introduce: 获取首界面信息
    **/
    @FormUrlEncoded
    @POST("/test/value")
    suspend fun getInfor(@Field("username") username : String,@Field("password") password : String) : BaseResp<MainDB>
}