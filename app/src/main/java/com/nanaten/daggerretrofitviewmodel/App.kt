package com.nanaten.daggerretrofitviewmodel

import android.app.Application
import com.nanaten.daggerretrofitviewmodel.di.app.ApiModule
import com.nanaten.daggerretrofitviewmodel.di.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.factory()
            .create(this)
    }
}

