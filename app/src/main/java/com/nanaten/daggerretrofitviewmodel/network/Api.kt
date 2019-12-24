package com.nanaten.daggerretrofitviewmodel.network

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("/repos/octocat/Hello-World")
    fun getHelloWorld(): Single<Repos>
}