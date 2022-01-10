package com.karelie.mvvmdemo.ui.login

import android.content.Intent
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karelie.commom.view.jumpWhere
import com.karelie.commom.view.textView
import com.karelie.commom.view.topBar
import com.karelie.mvvmdemo.ui.compose.ui.theme.Shapes
import com.karelie.mvvmdemo.ui.main.MainActivity
import kotlin.math.round

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showView()
        }
    }
    @Preview(name = "登录")
    @Composable
    fun showView(){
        Column() {
            TopAppBar(contentColor = Color.Black,backgroundColor = Color.White) {
                Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.Center) {
                    Text("登录")
                }
            }

            Row(modifier = Modifier.padding(top = 60.dp)) {
                Column(modifier = Modifier.fillMaxWidth(),horizontalAlignment = CenterHorizontally) {
                    var username by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }

                    Text(text = "欢迎进入Karelie系统~",Modifier.padding(50.dp))
                    //账号输入框
                    OutlinedTextField(
                        value = username,
                        onValueChange = {username = it},
                        placeholder = {
                            Text(
                                text = "请输入账号",
                                fontSize = 14.sp
                            )
                        },
                        singleLine = true,
                        maxLines = 1,
                        shape = Shapes.large,
                        modifier = Modifier
                            .align(alignment = CenterHorizontally)
                            .clip(
                                RoundedCornerShape(15.dp,15.dp,15.dp,15.dp))
//                        ,
//                        label = {
//                            Text(text = "用户名")
//                        }

                    )
                    //密码输入框
                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        placeholder = {
                            Text(
                                text = "请输入密码",
                                fontSize = 14.sp,
                            )
                        },
                        singleLine = true,
                        maxLines = 1,
                        shape = Shapes.large,
                        visualTransformation = PasswordVisualTransformation(),
                        modifier = Modifier
                            .align(alignment = CenterHorizontally)
                            .padding(top = 20.dp)
                            .clip(
                                RoundedCornerShape(15.dp,15.dp,15.dp,15.dp)),
                        label = {
                        Text(text = "密码")
                    }
                        )
                    //登录按钮
                    Button(
                        modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                            .padding(top = 20.dp)
                        ,
                        onClick = { loginOn() }) {
                        Text(text = "登录")
                    }
                }
            }



        }

    }

    fun loginOn(){
//        jumpWhere(MainActivity.javaClass)
        var intent : Intent? = Intent(this,MainActivity::class.java)
        this.startActivity(intent)
    }
    
    @Composable
    fun topBarView(){
        Text(text = "登录")
    }
}