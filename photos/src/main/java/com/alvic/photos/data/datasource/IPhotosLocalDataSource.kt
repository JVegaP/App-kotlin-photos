package com.alvic.photos.data.datasource

import com.alvic.photos.data.models.PhotoModel

interface IPhotosLocalDataSource {
    suspend fun deletePhotos()
    suspend fun savePhotos(photos: List<PhotoModel>)
    suspend fun getPhotos(): List<PhotoModel>
}