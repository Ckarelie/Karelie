package com.karelie.mvvmdemo.ui.viewpager

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.karelie.mvvmdemo.R
import com.karelie.mvvmdemo.databinding.FragmentMainBinding
import me.majiajie.pagerbottomtabstrip.NavigationController
import me.majiajie.pagerbottomtabstrip.PageNavigationView

class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
        initData()
    }

    private fun initData() {
        val controll  = binding.tab.material()
            .build()
        fun newFunction.doThree() = { karelie()}
    }


    class newFunction{
        fun doOne()= { karelie() }

        fun doTwo() = { karelie() }

        fun karelie(){}
    }





}