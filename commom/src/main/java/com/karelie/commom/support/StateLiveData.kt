package com.karelie.commom.support

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.karelie.commom.net.BaseResp
import com.karelie.commom.utils.toast

class StateLiveData <T> : MutableLiveData<BaseResp<T>>() {

    fun obserState(owner: LifecycleOwner,listenerBuilder : ListenerBuilder.() -> Unit) {
        val listener = ListenerBuilder().also(listenerBuilder)
        val value = object : IStateObserver<T>() {

            override fun onSuccess(data: T) {
                listener.mSuccessListenerAction?.invoke(data)
            }

            override fun onError(e: Throwable) {
                listener.mErrorListenerAction?.invoke(e) ?: toast("Http Error")
            }

            override fun onDataEmpty() {
                listener.mEmptyListenerAction?.invoke()
            }

            override fun onComplete() {
                listener.mCompleteListenerAction?.invoke()
            }

            override fun onFailed(errorCode: Int?, errorMsg: String?) {
                listener.mFailedListenerAction?.invoke(errorCode, errorMsg)
            }

        }
        super.observe(owner, value)
    }


    inner class ListenerBuilder {
        internal var mSuccessListenerAction: ((T) -> Unit)? = null
        internal var mErrorListenerAction: ((Throwable) -> Unit)? = null
        internal var mEmptyListenerAction: (() -> Unit)? = null
        internal var mCompleteListenerAction: (() -> Unit)? = null
        internal var mFailedListenerAction: ((Int?, String?) -> Unit)? = null

        fun onSuccess(action: (Any?) -> Unit) {
            mSuccessListenerAction = action
        }

        fun onFailed(action: (Int?, String?) -> Unit) {
            mFailedListenerAction = action
        }

        fun onException(action: (Throwable) -> Unit) {
            mErrorListenerAction = action
        }

        fun onEmpty(action: () -> Unit) {
            mEmptyListenerAction = action
        }

        fun onComplete(action: () -> Unit) {
            mCompleteListenerAction = action
        }
    }

}