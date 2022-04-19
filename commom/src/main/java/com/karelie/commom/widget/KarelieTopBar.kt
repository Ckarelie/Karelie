package com.karelie.commom.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.karelie.commom.R
import com.karelie.commom.databinding.WidgetKarelietopbaraBinding
import org.w3c.dom.Text

class KarelieTopBar : LinearLayout {
    private lateinit var leftView:ImageView
    private lateinit var mtitle:TextView
    private lateinit var rightMenu: TextView
    lateinit var binding : WidgetKarelietopbaraBinding
    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init(context, attrs)
    }

    fun init(context: Context, attrs: AttributeSet){
        val view = LayoutInflater.from(context).inflate(R.layout.widget_karelietopbara, this)
        leftView = view.findViewById(R.id.im_karelietopbar_back)
        mtitle = view.findViewById(R.id.tv_karelietopbar_titile)
        rightMenu = view.findViewById(R.id.tv_karelietopbar_right)
    }

    fun setBackView(viewId:Int){
        leftView.setBackgroundResource(viewId)
    }

    fun setTitle(title:String){
        mtitle.visibility = View.VISIBLE
        mtitle.text = title
    }

    fun showBackMenu(){
        leftView.visibility = View.VISIBLE
    }

    fun showRightMenu(right:String){
        rightMenu.visibility = View.VISIBLE
        rightMenu.text = right
    }

    fun getLeftBackView():ImageView{
        return leftView
    }

    fun getRightView():TextView{
        return rightMenu
    }

}