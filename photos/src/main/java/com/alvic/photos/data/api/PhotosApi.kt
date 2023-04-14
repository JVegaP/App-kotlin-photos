package com.alvic.photos.data.api

import com.alvic.photos.data.dtos.PhotoDTO
import retrofit2.http.GET

interface PhotosApi {
    @GET("photos")
    suspend fun getPhotos(): List<PhotoDTO>
}