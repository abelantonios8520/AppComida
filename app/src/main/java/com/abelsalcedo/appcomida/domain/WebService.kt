package com.abelsalcedo.appcomida.domain

import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {

    @GET("search.php?s=margarita")
    suspend fun getTragoByName(@Query("tragoName") tragoName:String)
}