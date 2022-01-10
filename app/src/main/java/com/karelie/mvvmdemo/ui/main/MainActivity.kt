package com.karelie.mvvmdemo.ui.main
import android.content.Intent
import  android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.karelie.mvvmdemo.bean.main.MainData

import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding
import com.karelie.mvvmdemo.ui.compose.ComposeActivity
import com.karelie.mvvmdemo.ui.viewpager.MainFragment
import com.karelie.mvvmdemo.ui.viewpager.MeFragment
import com.karelie.mvvmdemo.ui.viewpager.VPAdapter
import com.karelie.service.main.MineEnity
import com.karelie.service.main.MineTwoEnity
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
class MainActivity : AppCompatActivity() {
    val mineData by inject<MineEnity>()
    val twoData by inject<MineTwoEnity>()
    lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModel()
    private val config: ((BottomNavigationView, ViewPager2) -> Unit)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initData()
        initOnClick()
        initObserver()


    }

    private fun initObserver() {
        viewModel.userLiveData.obserState(this){
          onSuccess {
              it as MainData
              binding.tvTest.text = it.nickname
          }
        }
    }

    private fun initData() {
        config?.invoke(binding.bnvMain,binding.vpMain)
        binding.apply {
            binding.vpMain.adapter = VPAdapter(this@MainActivity,fragments)
            BnvVp2Mediator(binding.bnvMain,binding.vpMain){bnvMain,vpMain ->
                vpMain.isUserInputEnabled = true
            }.attach()
        }

    }

    private fun initOnClick() {
        binding.mainLogin.setOnClickListener {
            viewModel.login("FastJetpack","FastJetpack")
        }
        binding.mainClickforplay.setOnClickListener {
            binding.tvTest.text = ""
        }
        binding.btnComposeview.setOnClickListener {
            var intent : Intent? = Intent(this,ComposeActivity::class.java)
            startActivity(intent)
        }
    }

    //index
    companion object{
        const val  INDEX_MAIN = 0
        const val  INDEX_MINE = 1
    }
    private val fragments = mapOf<Int,Fragment>(
        INDEX_MAIN to MainFragment(),
        INDEX_MINE to MeFragment()
    )
}


/**
 * @Creator:Karelie
 * @Data: 2021/11/8
 * @TIME: 16:50
 * @Introduce: Connect viewpager & BottomNavigationView
**/
class BnvVp2Mediator(
    private val bnv: BottomNavigationView,
    private val vp2: ViewPager2,
    private val config: ((BottomNavigationView,ViewPager2) -> Unit)? = null
) {
    val map = mutableMapOf<MenuItem, Int>()
    init {
        //建立MenuItem的索引id映射
        bnv.menu.forEachIndexed { index, item ->
            map[item] = index
        }
    }
    fun attach() {
        //由于config是可空类型 所以必须用invoke执行
        config?.invoke(bnv,vp2)
        //监听viewPager的页面改变
        vp2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //通过position参数 设置BottomNavigationView选中的Item
                bnv.selectedItemId = bnv.menu.getItem(position).itemId
            }
        })
        //监听BottomNavigationView的item点击
        bnv.setOnNavigationItemSelectedListener { menuItem ->
            vp2.currentItem =
                map[menuItem] ?: error("BottomNavigationView的Item${menuItem.itemId}没有对应的元素")
            true
        }
    }
}
