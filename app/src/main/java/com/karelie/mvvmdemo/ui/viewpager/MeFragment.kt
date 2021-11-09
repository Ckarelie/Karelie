package com.karelie.mvvmdemo.ui.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.karelie.mvvmdemo.databinding.FragmentMeBinding

class MeFragment : Fragment() {
    lateinit var binding: FragmentMeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeBinding.inflate(layoutInflater)
        return binding.root
    }
}