package com.alvic.photos.domain.useCases

import com.alvic.photos.data.models.PhotoModel
import com.alvic.photos.domain.repositories.IPhotosRepository

class GetPhotosUseCase (
    private val photosRepository: IPhotosRepository
) {
    suspend fun invoke(isConnect: Boolean): List<PhotoModel> {
        return photosRepository.getPhotos(isConnect = isConnect)
    }
}