package com.example.amphibiansapp.network

import com.example.amphibiansapp.data.AmphibiansPhotos
import retrofit2.http.GET

interface AmphibiansApiService {
    @GET("photos")
    suspend fun getPhotos() : List<AmphibiansPhotos>
}