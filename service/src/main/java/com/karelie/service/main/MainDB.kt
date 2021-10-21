package com.karelie.service.main

import androidx.room.RoomDatabase

abstract class MainDB : RoomDatabase() {

    data class mainEnity(
        val title : String,
        val infor : String
    )

}