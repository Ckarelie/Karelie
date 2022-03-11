package com.karelie.commom.net

import com.karelie.commom.data.MineData
import com.karelie.commom.net.BaseResp
import com.karelie.mvvmdemo.resp.main.MainData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

public interface AppApiService {
    @FormUrlEncoded
    @POST("user/login")
    suspend fun login(@Field("username") userName: String, @Field("password") passWord: String): BaseResp<MainData?>

    @POST("wxarticle/chapters/json")
    suspend fun getList() : BaseResp<List<MineData>>

}