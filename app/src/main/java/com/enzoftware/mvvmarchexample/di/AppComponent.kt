package com.enzoftware.mvvmarchexample.di

import android.app.Application
import com.enzoftware.mvvmarchexample.GithubApp
import com.enzoftware.mvvmarchexample.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


/**
 * Created by Enzo Lizama Paredes on 2020-01-08.
 * Contact: lizama.enzo@gmail.com
 */
@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        NetworkModule::class
    ]
)
interface AppComponent : AndroidInjector<GithubApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun networkModule(networkModule: NetworkModule): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: GithubApp?)
}