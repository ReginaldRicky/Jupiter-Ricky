package com.example.jupiter_ricky.data.api

import com.example.jupiter_ricky.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}