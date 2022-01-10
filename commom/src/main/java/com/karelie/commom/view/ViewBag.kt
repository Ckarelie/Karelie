package com.karelie.commom.view

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource


@Composable
fun topBar(leftIconId: Int, midleTextShow: String, leftClick: () -> Unit) {
    TopAppBar() {
        Image(painter = painterResource(leftIconId),
            contentDescription = "返回",
            Modifier.clickable(
                true,
                onClick = leftClick
            )
        )
        Text(text = midleTextShow, modifier = Modifier.align(alignment = CenterVertically))
    }
}

@Composable
fun textView(name: String) {
    Text(text = name)
}



fun Activity.jumpWhere(toActivity: Class<Any>) {
    var intent: Intent? = Intent(this, toActivity::class.java)
    this.startActivity(intent)
}
