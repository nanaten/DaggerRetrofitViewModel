package com.nanaten.daggerretrofitviewmodel.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nanaten.daggerretrofitviewmodel.domain.MainUseCase
import com.nanaten.daggerretrofitviewmodel.network.Repos
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(private val useCase: MainUseCase): ViewModel() {
    val data = MutableLiveData<Repos>()

    fun getRepos() {
        useCase.getHelloWorld()
            .subscribe ({
                data.postValue(it)
            }, {
                it.printStackTrace()
            })
            .addTo(CompositeDisposable())
    }
}