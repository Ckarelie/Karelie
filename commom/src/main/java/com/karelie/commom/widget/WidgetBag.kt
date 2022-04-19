package com.karelie.commom.widget

import android.content.Context
import android.widget.Toast

fun KarelieTopBar.initBack(
    title:String,
    rightMenu:String,
    onBack:() -> Unit?
):KarelieTopBar{
    this.setTitle(title = title)
    this.showBackMenu()
    this.showRightMenu(right = rightMenu)
    this.getLeftBackView().setOnClickListener { onBack.invoke() }
    return this
}

fun KarelieTopBar.initBack(
    backView:Int,
    title:String,
    rightMenu:String,
    onBack: () ->Unit?,
    rightUnit:() -> Unit?
):KarelieTopBar{
    this.setBackView(backView)
    this.setTitle(title = title)
    this.showBackMenu()
    this.showRightMenu(right = rightMenu)
    this.getLeftBackView().setOnClickListener { onBack.invoke() }
    this.getRightView().setOnClickListener { rightUnit.invoke() }
    return this
}

