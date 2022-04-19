package com.karelie.commom.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.karelie.commom.R

abstract class BaseActivity<DB:ViewDataBinding> :AppCompatActivity(){
    var dataBindView : View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_base)
        initView(savedInstanceState)
    }

    open fun initView(savedInstanceState: Bundle?) {
        dataBindView = initViewDataBind()
    }

    /**
     * 供子类BaseVmDbActivity 初始化 DataBinding ViewBinding操作
     */
    open fun initViewDataBind(): View? {
        return null
    }
}