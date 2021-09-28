package com.shuke.mvpcore.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment  : Fragment(){

    protected lateinit var baseView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        baseView = inflater.inflate(getLayoutId(),null,false)
        return baseView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
        initEvent()
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
     * 根据Id获取控件
     */
    fun <T> findViewById(id:Int):T{
        return baseView.findViewById(id)
    }
}