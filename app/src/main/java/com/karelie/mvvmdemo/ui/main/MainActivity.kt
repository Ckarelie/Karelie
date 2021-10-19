package com.karelie.mvvmdemo.ui.main
import  android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.karelie.mvvmdemo.R
import com.karelie.mvvmdemo.bean.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bingding : ActivityMainBinding
    private var viewModel : MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
    }
}