package com.shuke.mvvmcore.view

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

class BaseActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //是否设置沉浸式
        if(IsClearBar()){
            ClearStatusBar()
        }
    }

    /**
     * 实现沉浸式
     */
    private fun ClearStatusBar() {
        if (Build.VERSION.SDK_INT in 19..21){
            this.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        }
        else if(Build.VERSION.SDK_INT  >= 22){
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.TRANSPARENT
        }
    }

    /**
     * 是否实现沉浸式状态栏
     * 默认实现
     */
    private fun IsClearBar(): Boolean {
        return true
    }
}