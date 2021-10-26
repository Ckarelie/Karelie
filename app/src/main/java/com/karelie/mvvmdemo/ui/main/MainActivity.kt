package com.karelie.mvvmdemo.ui.main
import  android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.karelie.mvvmdemo.bean.main.MainData
import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bingding : ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bingding.root)
        initData()
        initObserver()
    }

    private fun initObserver() {
        viewModel.userLiveData.obserState(this){
            onSuccess { result : MainData? ->
                result?.let {
                    val data : String? = result.nickname
                    bingding.tvTest.text = "欢迎登录：" +data
                }
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