package com.karelie.mvvmdemo.ui.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.karelie.mvvmdemo.ui.main.MainActivity
import com.karelie.mvvmdemo.ui.me.MineActivity

class VPAdapter(val activity: FragmentActivity,
                private val fragments: Map<Int, Fragment>) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int  = fragments.size

    override fun createFragment(position: Int): Fragment =
        fragments.get(position) ?: error("请确保fragments数据源和ViewPager2的index匹配设置")



}