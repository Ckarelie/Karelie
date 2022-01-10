package com.karelie.mvvmdemo.ui.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.didichuxing.doraemonkit.util.ToastUtils
import com.karelie.commom.view.topBar
import com.karelie.commom.view.textView
import com.karelie.mvvmdemo.R

class ComposeActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            ShowView()
        }
    }
    @Preview(name = "基础组件")
    @Composable
    fun ShowView(){
        Column {
            topBar(
                leftIconId = R.mipmap.app_icon,
                midleTextShow ="Compose界面"
            ) { finish() }

            Row {
                textView("没错是的")
                textView(",")
                textView("我不好")
            }

            Row {
                textView("真秀啊你们")
            }
            Image(painter = painterResource(id = R.mipmap.app_icon),
                contentDescription = "图标",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(100.dp)
                    .padding(20.dp)
                )

            Column() {
               Button(onClick = { showText("哈哈哈") }) {
                   Text(text = "普通按钮")
               }

                TextButton(onClick = { showText("呵呵呵") }) {
                    Text(text = "文字按钮")
                }


            }
        }

    }

    fun showText(text : String){
        ToastUtils.showShort(text)
    }


}