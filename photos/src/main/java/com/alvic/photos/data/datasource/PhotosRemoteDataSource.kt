package com.alvic.photos.data.datasource

import com.alvic.photos.data.api.PhotosApi
import com.alvic.photos.data.mappers.toListPhotoModel
import com.alvic.photos.data.models.PhotoModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PhotosRemoteDataSource (
    private val photosApi: PhotosApi
): IPhotosRemoteDataSource {

    override suspend fun getPhotos(): List<PhotoModel> {
        return withContext(Dispatchers.IO) {
            photosApi.getPhotos().toListPhotoModel()
        }
    }
}