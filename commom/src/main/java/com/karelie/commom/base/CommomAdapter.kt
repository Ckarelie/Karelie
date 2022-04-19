package com.karelie.commom.base

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.karelie.commom.R

class CommomAdapter(arraylist:ArrayList<Any>): BaseQuickAdapter<Any, BaseViewHolder>(R.layout.item_title_commom) {
    override fun convert(holder: BaseViewHolder, item: Any) {
        holder.setText(R.id.atv_commom_title,item.toString())
    }
}