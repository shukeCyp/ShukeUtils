package com.shuke.mvpcore.inject

import android.os.Build
import com.shuke.mvpcore.BaseRepository
import com.shuke.mvpcore.IView
import com.shuke.mvpcore.annotation.Model
import com.shuke.mvpcore.annotation.Presenter
import java.lang.IllegalArgumentException

object Injection {

    fun injectModel(repository:BaseRepository){
        val javaClass = repository.javaClass
        val declaredFields = javaClass.declaredFields
        if (declaredFields.size == 0){
            throw IllegalArgumentException("当前Repository没有字段")
        }
        else{
            var hasModel = false
            for (field in  declaredFields){
                field.isAccessible = true
                var name:String = ""
                val annotation = field.getAnnotation(Model::class.java)
                if (annotation != null){
                    hasModel = true
                    if (Build.VERSION.SDK_INT >= 28){
                        name = field.genericType.typeName
                    }
                    else{
                        name = field.type.name
                    }
                    val forName = Class.forName(name)
                    val newInstance = forName.newInstance()
                    field.set(this,newInstance)
                }
            }
            if (!hasModel){
                throw IllegalArgumentException("当前Repository没有Model")
            }
        }

    }

    fun injectPresenter(view:IView){
        val javaClass = view.javaClass
        val declaredFields = javaClass.declaredFields
        if (declaredFields.size == 0){
            throw IllegalArgumentException("当前View没有字段")
        }
        else{
            var hasPresenter = false
            for (field in  declaredFields){
                field.isAccessible = true
                var name:String = ""
                val annotation = field.getAnnotation(Presenter::class.java)
                if (annotation != null){
                    hasPresenter = true
                    if (Build.VERSION.SDK_INT >= 28){
                        name = field.genericType.typeName
                    }
                    else{
                        name = field.type.name
                    }
                    val forName = Class.forName(name)
                    val newInstance = forName.declaredConstructors.get(0).newInstance(view)
                    field.set(this,newInstance)
                }
            }
            if (!hasPresenter){
                throw IllegalArgumentException("当前View没有Presenter")
            }
        }

    }
}