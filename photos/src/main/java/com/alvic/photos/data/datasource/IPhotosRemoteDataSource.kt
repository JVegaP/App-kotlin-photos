package com.alvic.photos.data.datasource

import com.alvic.photos.data.models.PhotoModel

interface IPhotosRemoteDataSource {
    suspend fun getPhotos(): List<PhotoModel>
}