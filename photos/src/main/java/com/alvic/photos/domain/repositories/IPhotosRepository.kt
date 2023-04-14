package com.alvic.photos.domain.repositories

import com.alvic.photos.data.models.PhotoModel

interface IPhotosRepository {
    suspend fun getPhotos(isConnect: Boolean): List<PhotoModel>
    suspend fun deletePhotos()
}