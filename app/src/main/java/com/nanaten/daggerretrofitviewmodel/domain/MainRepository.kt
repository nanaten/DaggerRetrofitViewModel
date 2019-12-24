package com.nanaten.daggerretrofitviewmodel.domain

import com.nanaten.daggerretrofitviewmodel.network.Api
import com.nanaten.daggerretrofitviewmodel.network.Repos
import io.reactivex.Single
import java.lang.Exception
import javax.inject.Inject

interface MainRepository {
    fun getHelloWorld(): Single<Repos>
}

class MainRepositoryImpl @Inject constructor(private val api: Api) : MainRepository {
    override fun getHelloWorld(): Single<Repos> {
        return api.getHelloWorld()
    }
}