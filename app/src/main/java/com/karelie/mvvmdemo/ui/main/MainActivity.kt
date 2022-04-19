package com.karelie.mvvmdemo.ui.main
import android.content.Intent
import android.location.LocationManager
import android.os.Build
import  android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.graphics.Color
import androidx.core.view.forEachIndexed
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.didi.drouter.annotation.Router
import com.didi.drouter.api.DRouter
import com.didi.drouter.api.Extend
import com.didi.drouter.router.Result
import com.didi.drouter.router.RouterCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.hjq.toast.ToastUtils
import com.karelie.commom.base.BaseActivity
import com.karelie.commom.base.CommomAdapter
import com.karelie.commom.router.Router.SecondMoudle.secondMain
import com.karelie.commom.utils.toast
import com.karelie.commom.widget.initBack

import com.karelie.mvvmdemo.R
import com.karelie.mvvmdemo.resp.main.MainData

import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.mvvmdemo.databinding.ActivityMainBinding
import com.karelie.mvvmdemo.ui.compose.ComposeActivity
import com.karelie.mvvmdemo.ui.viewpager.MainFragment
import com.karelie.mvvmdemo.ui.viewpager.MeFragment
import com.karelie.mvvmdemo.ui.viewpager.VPAdapter
import com.karelie.service.main.MineEnity
import com.karelie.service.main.MineTwoEnity
import com.kongzue.dialogx.dialogs.MessageDialog
import com.kongzue.dialogx.dialogs.TipDialog
import com.kongzue.dialogx.dialogs.WaitDialog
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.absoluteValue

@Router(path = "/main")
class MainActivity : BaseActivity<ActivityMainBinding>() {
    val mineData by inject<MineEnity>()
    val twoData by inject<MineTwoEnity>()
    lateinit var binding : ActivityMainBinding
    private val viewModel : MainViewModel by viewModel()
    private val mAdapter: CommomAdapter by lazy { CommomAdapter(arrayListOf()) }
    private val config: ((BottomNavigationView, ViewPager2) -> Unit)? = null
    var manger: LocationManager? = null
    private val TAG:String = "MainMoudle_MainActivity"
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

        val b = showBase("a dui ")
        showWt(b).showToast()

    }

    interface Base{
       fun showToast()
    }
    class showBase(val message:String):Base{
        override fun showToast() {
            Log.i("KarelieWt", "showToast: "+message)
        }
    }

    class showWt(b:Base): Base by b


    private fun initData() {
        config?.invoke(binding.bnvMain,binding.vpMain)
        binding.apply {
            binding.vpMain.adapter = VPAdapter(this@MainActivity,fragments)
            BnvVp2Mediator(binding.bnvMain,binding.vpMain){bnvMain,vpMain ->
                vpMain.isUserInputEnabled = true
            }.attach()

            ktbMain.initBack(R.mipmap.back_topbar,"主页","分享",{finish()}) {
                DRouter.build(secondMain)
                    .putExtra("jump","1")
                    .start(this@MainActivity){
                        if (it.isActivityStarted){
                            Log.i(TAG, "Jump Status: "+"===Success===")
                        }
                    }
            }


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

        val list = listOf<checkList>(
            checkList("1",3),
            checkList("2",2),
            checkList("3",1)
        )
    }

    fun getAbNumber(number:Double): Double {
        return number.absoluteValue
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

data class checkList(val name:String, val other:Any)

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
