package com.shuke.mvpcore.view

import com.shuke.mvpcore.IView
import com.shuke.mvpcore.inject.Injection

abstract class MVPActivity : BaseActivity(),IView {
    init {
        Injection.injectPresenter(this)
    }
}