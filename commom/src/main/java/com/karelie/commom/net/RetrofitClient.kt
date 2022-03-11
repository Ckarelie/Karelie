package com.karelie.commom.net

import okhttp3.OkHttpClient

object RetrofitClient : BaseRetrofitClient() {
    val service by lazy { getService(AppApiService::class.java, ApiService.BASE_URL) }
    override fun handleBuilder(builder: OkHttpClient.Builder) = Unit
}