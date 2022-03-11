package com.karelie.mvvmdemo.resp.mine

import com.karelie.commom.data.MineData
import com.karelie.commom.net.BaseRepository
import com.karelie.commom.net.BaseResp
import com.karelie.commom.net.RetrofitClient

class MineRepository : BaseRepository() {
    private val mService by lazy {
        RetrofitClient.service
    }

    suspend fun getInfor() :BaseResp<List<MineData>>{
        return mService.getList()
    }
}