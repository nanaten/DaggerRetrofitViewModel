package com.nanaten.daggerretrofitviewmodel.di.app

import android.content.Context
import com.nanaten.daggerretrofitviewmodel.App
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: App): Context

}