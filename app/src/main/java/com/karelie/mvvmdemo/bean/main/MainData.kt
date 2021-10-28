package com.karelie.mvvmdemo.bean.main

data class MainData(
    var title: MainData?,
    var infor: String?,
    val nickname: String?
    )


data class MainList(
    val item : List<ListBean>
)

data class ListBean(
    var id : Int?,
    var name: String?,
    var visible : Int,
)
