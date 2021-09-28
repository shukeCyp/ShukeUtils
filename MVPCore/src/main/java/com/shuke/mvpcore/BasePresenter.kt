package com.shuke.mvpcore

abstract class BasePresenter<V : IView,Repo : BaseRepository>(var view : V) {
    protected var repository:Repo

    init {
        repository = createRepository()
    }

    abstract fun createRepository(): Repo
}