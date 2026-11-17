package com.example.jupiter_ricky.data.api

import com.example.jupiter_ricky.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}
