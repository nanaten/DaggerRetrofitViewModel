package com.nanaten.daggerretrofitviewmodel.di.app

import android.content.Context
import com.nanaten.daggerretrofitviewmodel.App
import com.nanaten.daggerretrofitviewmodel.di.domain.MainModule
import com.nanaten.daggerretrofitviewmodel.di.ui.MainActivityBuilder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ApiModule::class,
        MainActivityBuilder::class,
        MainModule::class
    ]
)

interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App,
                   @BindsInstance apiModule: ApiModule): AppComponent
    }

}

