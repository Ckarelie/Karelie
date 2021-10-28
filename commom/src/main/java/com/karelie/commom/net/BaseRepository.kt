package com.karelie.commom.net

import com.karelie.commom.BuildConfig
import com.karelie.commom.net.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import java.util.*

open class BaseRepository() {
    suspend fun <T> executeHttp(block: suspend () -> BaseResp<T>): BaseResp<T> {
        //for test
        delay(500)
        runCatching {
            block.invoke()
        }.onSuccess { data: BaseResp<T> ->
            return handleHttpOk(data)
        }.onFailure { e ->
            return handleHttpError(e)
        }
        return ApiEmptyResponse()
    }

    /**
     * 非后台返回错误，捕获到的异常
     */
    private fun <T> handleHttpError(e: Throwable): ApiErrorResponse<T> {
        if (BuildConfig.DEBUG) e.printStackTrace()
        handlingExceptions(e)
        return ApiErrorResponse(e)
    }

    /**
     * 返回200，但是还要判断isSuccess
     */
    private fun <T> handleHttpOk(data: BaseResp<T>): BaseResp<T> {
        return if (data.isSuccess) {
            getHttpSuccessResponse(data)
        } else {
            handlingApiExceptions(data.errorCode, data.errorMsg)
            ApiFailedResponse(data.errorCode, data.errorMsg)
        }
    }

    /**
     * 成功和数据为空的处理
     */
    private fun <T> getHttpSuccessResponse(response: BaseResp<T>): BaseResp<T> {
        val data = response.data
        return if (data == null || data is List<*> && (data as List<*>).isEmpty()) {
            ApiEmptyResponse()
        } else {
            ApiSuccessResponse(data)
        }
    }
}