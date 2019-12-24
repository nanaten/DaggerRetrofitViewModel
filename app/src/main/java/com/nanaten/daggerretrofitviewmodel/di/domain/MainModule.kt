package com.nanaten.daggerretrofitviewmodel.di.domain

import com.nanaten.daggerretrofitviewmodel.network.Api
import com.nanaten.daggerretrofitviewmodel.domain.MainRepository
import com.nanaten.daggerretrofitviewmodel.domain.MainRepositoryImpl
import com.nanaten.daggerretrofitviewmodel.domain.MainUseCase
import com.nanaten.daggerretrofitviewmodel.domain.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object MainModule {
    @Singleton
    @Provides
    @JvmStatic
    fun provideMainRepository(api: Api): MainRepository =
        MainRepositoryImpl(api)

    @Singleton
    @Provides
    @JvmStatic
    fun provideMainUseCase(repository: MainRepository): MainUseCase =
        MainUseCaseImpl(repository)
}