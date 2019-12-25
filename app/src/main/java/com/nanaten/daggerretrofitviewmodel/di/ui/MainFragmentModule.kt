package com.nanaten.daggerretrofitviewmodel.di.ui

import androidx.lifecycle.ViewModel
import com.nanaten.daggerretrofitviewmodel.di.FragmentScope
import com.nanaten.daggerretrofitviewmodel.di.domain.MainModule
import com.nanaten.daggerretrofitviewmodel.di.viewmodel.ViewModelKey
import com.nanaten.daggerretrofitviewmodel.ui.MainFragment
import com.nanaten.daggerretrofitviewmodel.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
@Suppress("UNUSED")
internal abstract class MainFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @FragmentScope
    internal abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    @FragmentScope
    abstract fun provideMainFragment(): MainFragment

}