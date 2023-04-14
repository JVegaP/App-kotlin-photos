package com.alvic.photos.data.datasource

import com.alvic.photos.data.api.PhotosDao
import com.alvic.photos.data.mappers.toListPhotoEntity
import com.alvic.photos.data.mappers.toListPhotoModelFromEntity
import com.alvic.photos.data.models.PhotoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosLocalDataSource(
    private val photosDao: PhotosDao
): IPhotosLocalDataSource {
    override suspend fun getPhotos(): List<PhotoModel> {
        return withContext(Dispatchers.IO) {
            photosDao.getPhotos().toListPhotoModelFromEntity()
        }
    }

    override suspend fun savePhotos(photos: List<PhotoModel>) {
        withContext(Dispatchers.IO) {
            photosDao.insert(photos = photos.toListPhotoEntity())
        }
    }

    override suspend fun deletePhotos() {
        withContext(Dispatchers.IO) {
            photosDao.deletePhotos()
        }
    }
}