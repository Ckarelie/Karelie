package com.karelie.mvvmdemo.di

import com.karelie.mvvmdemo.base.BaseViewModel
import com.karelie.mvvmdemo.resp.main.MainRepository

class LoginViewModel : BaseViewModel() {
    private val repository by lazy { MainRepository() }
}