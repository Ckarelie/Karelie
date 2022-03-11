package com.karelie.mvvmdemo.app

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.didi.drouter.api.DRouter
import com.didichuxing.doraemonkit.DoKit
import com.github.gzuliyujiang.oaid.DeviceIdentifier
import com.karelie.commom.net.BaseRepository
import com.karelie.mvvmdemo.di.MainViewModel
import com.karelie.commom.net.RetrofitClient
import com.karelie.service.main.MineEnity
import com.karelie.service.main.MineTwoEnity
import com.tencent.bugly.Bugly
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class KarelieApp: Application() {

    override fun onCreate() {
        super.onCreate()
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(this, "910ab0e291", false)
        DeviceIdentifier.register(this)
        DoKit.Builder(this)
            .build()
        DRouter.init(this)
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@KarelieApp)
            androidFileProperties()
            modules(listOf(
                viewModel,
                repoModel,
                utilsModel
            ))
        }
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base)
        // 安装tinker
//        Beta.installTinker()
    }

    val viewModel = module {
        viewModel{
            MainViewModel()
        }
    }

    val repoModel = module {
        single {
            BaseRepository()
            RetrofitClient
        }
    }

    val utilsModel = module {
        factory { MineEnity(this@KarelieApp) }
        factory { MineTwoEnity(get()) }
    }

    val secondModel = module {
        factory {

        }
    }
}