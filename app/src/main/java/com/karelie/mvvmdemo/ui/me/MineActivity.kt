package com.karelie.mvvmdemo.ui.me

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.karelie.mvvmdemo.databinding.ActivityMainBinding
import com.karelie.mvvmdemo.databinding.ActivityMineBinding
import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.di.MineViewModel

/**
 *  @Author: Karelie
 *  @Method：MineActivity
 *  @Date：2022/3/11 17:51
 *  @Description：我的界面
 */
class MineActivity : AppCompatActivity() {
    lateinit var bingding : ActivityMineBinding
    private val viewModel by viewModels<MineViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMineBinding.inflate(layoutInflater)
        setContentView(bingding.root)
        initOnClick()
    }

    private fun initOnClick() {
        bingding.apply {

        }
    }
}