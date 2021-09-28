package com.shuke.mvpcore

import com.shuke.mvpcore.inject.Injection

class BaseRepository {

    init {
        Injection.injectModel(this)
    }


}