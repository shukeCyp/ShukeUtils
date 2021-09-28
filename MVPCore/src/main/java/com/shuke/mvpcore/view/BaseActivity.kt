package com.shuke.mvpcore.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initData()
        initEvent()
        if (IsClearBar()){
            ClearBar()
        }
    }

    /**
     * 实现沉浸式布局
     */
    fun ClearBar(){
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View
            .SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT
    }

    /**
     * 是否实现沉浸式,默认实现
     */
    fun IsClearBar(): Boolean{
        return true
    }

    /**
     * 初始化事件
     */
    abstract fun initEvent()

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化控件
     */
    abstract fun initView()

    /**
     * 获取布局Id
     */
    abstract fun getLayoutId(): Int

    /**
     * 实现不带参数跳转
     */
    fun jumpActivity(clazz: Class<Activity>,isFinish:Boolean){
        var intent : Intent = Intent(this,clazz)
        startActivity(intent)
        if (isFinish){
            this.finish()
        }
    }

    /**
     * 带Bundle跳转
     */
    fun jumpActivityWithBundle(clazz: Class<Activity>,bundle: Bundle,isFinish:Boolean){
        var intent : Intent = Intent(this,clazz)
        intent.putExtra("bundle",bundle)
        startActivity(intent)
        if (isFinish){
            this.finish()
        }
    }

}