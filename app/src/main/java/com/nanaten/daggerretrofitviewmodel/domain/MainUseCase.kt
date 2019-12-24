package com.nanaten.daggerretrofitviewmodel.domain

import com.nanaten.daggerretrofitviewmodel.network.Repos
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface MainUseCase {
    fun getHelloWorld(): Single<Repos>
}

class MainUseCaseImpl @Inject constructor(private val repository: MainRepository): MainUseCase {
    override fun getHelloWorld(): Single<Repos> {
        return repository.getHelloWorld()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
    }
}