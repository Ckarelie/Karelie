package com.karelie.mvvmdemo.ui.me

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.karelie.mvvmdemo.databinding.ActivityMainBinding
import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.di.MineViewModel

class MineActivity : AppCompatActivity() {
    lateinit var bingding : ActivityMainBinding
    private val viewModel by viewModels<MineViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bingding.root)

    }
}