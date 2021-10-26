package com.karelie.mvvmdemo.ui.main
import  android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.karelie.mvvmdemo.bean.main.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bingding : ActivityMainBinding
    private var viewModel : MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bingding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bingding.root)
        bingding.tvTest.text = "无语le "
    }
}