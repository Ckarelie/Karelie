package com.karelie.commom.utils

import androidx.compose.ui.graphics.Color
import com.jeremyliao.liveeventbus.LiveEventBus
import com.kongzue.dialogx.DialogX
import com.kongzue.dialogx.dialogs.MessageDialog
import com.kongzue.dialogx.interfaces.OnDialogButtonClickListener

const val SHOW_TOAST = "show_toast"

const val LOADING_STATE = "loading_state"
fun toast(msg : String){
    LiveEventBus.get<String>(SHOW_TOAST).post(msg)
}