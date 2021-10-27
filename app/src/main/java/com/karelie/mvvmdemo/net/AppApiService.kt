package com.karelie.mvvmdemo.net

import com.karelie.commom.net.BaseResp
import com.karelie.mvvmdemo.bean.main.MainData
import com.karelie.mvvmdemo.bean.mine.MineData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AppApiService {
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): BaseResp<MainData?>

    @POST("wxarticle/chapters/json")
    suspend fun getList() : BaseResp<List<MineData>>


}