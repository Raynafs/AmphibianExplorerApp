package com.example.amphibiansapp.network

import com.example.amphibiansapp.data.AmphibiansPhotos

interface AmphibiansRepository {
    suspend fun getAnimalPhotos() : List<AmphibiansPhotos>
}

class NetworkAmphibiansPhotosRepository(
    private val amphibiansApi : AmphibiansApiService
    ):AmphibiansRepository {
    override suspend fun getAnimalPhotos(): List<AmphibiansPhotos>  = amphibiansApi.getPhotos()
}