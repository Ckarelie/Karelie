package com.karelie.mvvmdemo.base
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremyliao.liveeventbus.LiveEventBus
import com.karelie.arch.response.ResponseThrowable
import com.karelie.commom.net.BaseResp
import com.karelie.commom.utils.LOADING_STATE
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect

private typealias CommonCallback = suspend CoroutineScope.() -> Unit
private typealias ErrorCallback = suspend CoroutineScope.(ResponseThrowable) -> Unit

open class BaseViewModel : ViewModel(){

    protected fun showLoadingV2() {
        LiveEventBus.get<Boolean>(LOADING_STATE).post(true)
    }

    protected fun stopLoadingV2() {
        LiveEventBus.get<Boolean>(LOADING_STATE).post(false)
    }

    protected fun <T> launchWithLoading(
        requestBlock: suspend () -> BaseResp<T>,
        resultCallback: (BaseResp<T>) -> Unit
    ) {
        viewModelScope.launch {
            flow {
                emit(requestBlock.invoke())
            }.onStart {
                showLoadingV2()
            }.onCompletion {
                stopLoadingV2()
            }.collect {
                resultCallback(it)
            }
        }
    }

}