package com.nanaten.daggerretrofitviewmodel.network

import com.google.gson.annotations.SerializedName

data class Repos(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)