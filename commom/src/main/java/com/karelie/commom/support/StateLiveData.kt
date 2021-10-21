package com.karelie.commom.support

import androidx.lifecycle.MutableLiveData
import com.karelie.commom.net.BaseResp

class StateLiveData <T> : MutableLiveData<BaseResp<T>>() {
}