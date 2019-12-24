package com.nanaten.daggerretrofitviewmodel

import android.app.Application
import com.nanaten.daggerretrofitviewmodel.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchActivityInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any>{
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
        return dispatchActivityInjector
    }
}