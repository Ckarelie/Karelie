package com.karelie.mvvmdemo.bean.mine

import com.karelie.commom.net.BaseRepository
import com.karelie.commom.net.BaseResp
import com.karelie.mvvmdemo.net.RetrofitClient

class MineRepository : BaseRepository() {
    private val mService by lazy {
        RetrofitClient.service
    }

    suspend fun getInfor() :BaseResp<List<MineData>>{
        return mService.getList()
    }
}