package com.shuke.mvpcore.view

import com.shuke.mvpcore.IView
import com.shuke.mvpcore.inject.Injection

abstract class MVPFragment : BaseFragment(),IView {

    init {
        Injection.injectPresenter(this)
    }

}