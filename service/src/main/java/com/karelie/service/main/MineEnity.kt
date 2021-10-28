package com.karelie.service.main

import android.content.Context
import android.widget.Toast

class MineEnity(val context: Context){
    fun getInfor(infor : String) {
        Toast.makeText(context,infor,Toast.LENGTH_SHORT).show()
    }
}

class MineTwoEnity(val enity : MineEnity){
    fun getTwoInfor(infor2: String){
        enity.getInfor(infor2)
    }
}