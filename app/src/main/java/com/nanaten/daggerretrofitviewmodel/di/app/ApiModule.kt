package com.nanaten.daggerretrofitviewmodel.di.app

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.nanaten.daggerretrofitviewmodel.network.Api
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class ApiModule {
    companion object {
        const val API_READ_TIMEOUT: Long = 10
        const val API_CONNECT_TIMEOUT: Long = 10
    }

    private val gson =
        GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()

    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
            .addInterceptor {
                val httpUrl = it.request().url
                val requestBuilder = it.request().newBuilder().url(httpUrl)
                it.proceed(requestBuilder.build())
            }
            .addInterceptor(logInterceptor)
            .readTimeout(API_READ_TIMEOUT, TimeUnit.SECONDS)
            .connectTimeout(API_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAPI( retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}