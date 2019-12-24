package com.nanaten.daggerretrofitviewmodel.di.ui

import com.nanaten.daggerretrofitviewmodel.di.ActivityScope
import com.nanaten.daggerretrofitviewmodel.di.domain.MainModule
import com.nanaten.daggerretrofitviewmodel.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityBuilder {
    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            MainFragmentModule::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity
}