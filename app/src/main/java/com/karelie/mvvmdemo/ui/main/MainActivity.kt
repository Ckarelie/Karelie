package com.karelie.mvvmdemo.ui.main
import  android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.karelie.commom.support.StateLiveData
import com.karelie.mvvmdemo.bean.main.MainData

import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding
import com.karelie.service.main.MineEnity
import com.karelie.service.main.MineTwoEnity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {
    val mineData by inject<MineEnity>()
    val twoData by inject<MineTwoEnity>()
    lateinit var bingding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bingding.root)
        initData()
        initObserver()
    }

    private fun initObserver() {
        viewModel.userLiveData.obserState(this){
          onSuccess {
              it as MainData
              bingding.tvTest.text = it.nickname
          }
        }
    }

    private fun initData() {
        bingding.mainLogin.setOnClickListener {
            viewModel.login("FastJetpack","FastJetpack")
        }

        bingding.mainClickforplay.setOnClickListener {
            bingding.tvTest.text = ""
        }
    }
}