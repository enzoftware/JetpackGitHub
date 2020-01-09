package com.enzoftware.mvvmarchexample

import android.content.Context
import com.enzoftware.mvvmarchexample.di.DaggerAppComponent
import com.enzoftware.mvvmarchexample.di.modules.NetworkModule
import com.jakewharton.threetenabp.AndroidThreeTen
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


/**
 *
 *Application class. [DaggerApplication] inject classes behind the scene.
 */
open class GithubApp : DaggerApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        initAndroidThreeTen()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .networkModule(NetworkModule())
            .build()
    }

    protected open fun initAndroidThreeTen() {
        AndroidThreeTen.init(this)
    }
}

