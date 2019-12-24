package com.nanaten.daggerretrofitviewmodel.di.app

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
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun api(apiModule: ApiModule): Builder
        fun build(): AppComponent
    }

    override fun inject(application: App)

}

