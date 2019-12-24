
package com.nanaten.daggerretrofitviewmodel.di.viewmodel


import androidx.lifecycle.ViewModelProvider
import com.nanaten.daggerretrofitviewmodel.di.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
