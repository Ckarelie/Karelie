package com.karelie.commom.support

import androidx.lifecycle.Observer
import com.karelie.commom.net.*

abstract class IStateObserver <T> : Observer<BaseResp<T>> {

    override fun onChanged(apiResponse: BaseResp<T>) {
        when (apiResponse) {
            is ApiSuccessResponse -> onSuccess(apiResponse.response)
            is ApiEmptyResponse -> onDataEmpty()
            is ApiFailedResponse -> onFailed(apiResponse.errorCode, apiResponse.errorMsg)
            is ApiErrorResponse -> onError(apiResponse.throwable)
        }
        onComplete()
    }

    abstract fun onSuccess(data: T)

    abstract fun onDataEmpty()

    abstract fun onError(e: Throwable)

    abstract fun onComplete()

    abstract fun onFailed(errorCode: Int?, errorMsg: String?)

}