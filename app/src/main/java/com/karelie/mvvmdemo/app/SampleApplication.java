package com.karelie.mvvmdemo.app;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import androidx.multidex.MultiDex;

import com.github.gzuliyujiang.oaid.DeviceIdentifier;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import java.util.Locale;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(this, "910ab0e291", false);
        DeviceIdentifier.register(this);

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);

        // 安装tinker
        Beta.installTinker();
    }
}
