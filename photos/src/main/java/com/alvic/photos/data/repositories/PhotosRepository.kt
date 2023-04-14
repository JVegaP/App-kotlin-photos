package com.alvic.photos.data.repositories

import com.alvic.photos.data.datasource.IPhotosLocalDataSource
import com.alvic.photos.data.datasource.IPhotosRemoteDataSource
import com.alvic.photos.data.models.PhotoModel
import com.alvic.photos.domain.repositories.IPhotosRepository

class PhotosRepository(
    private val photosRemoteDataSource: IPhotosRemoteDataSource,
    private val photosLocalDataSource: IPhotosLocalDataSource
):IPhotosRepository {
    override suspend fun getPhotos(isConnect: Boolean): List<PhotoModel> {
        if(!isConnect) return photosLocalDataSource.getPhotos()
        val result = photosRemoteDataSource.getPhotos()
        savePhotos(photos = result)
        return result
    }

    private suspend fun savePhotos(photos: List<PhotoModel>) {
        photosLocalDataSource.savePhotos(photos = photos)
    }

    override suspend fun deletePhotos() {
        photosLocalDataSource.deletePhotos()
    }
}