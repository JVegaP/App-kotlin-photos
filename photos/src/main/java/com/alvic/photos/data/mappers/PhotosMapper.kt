package com.alvic.photos.data.mappers

import com.alvic.photos.core.AppConstants
import com.alvic.photos.data.dtos.PhotoDTO
import com.alvic.photos.data.entities.PhotoEntity
import com.alvic.photos.data.models.PhotoModel

fun PhotoDTO.toPhotoModel(): PhotoModel {
    return PhotoModel(
        idAlbum = idAlbum?: -1,
        id = id?: -1,
        namePhoto = namePhoto?: AppConstants.DEFAULT_EMPTY_STRING,
        urlPhoto = urlPhoto?: AppConstants.DEFAULT_EMPTY_STRING,
        urlPreviewPhoto = urlPreviewPhoto?: AppConstants.DEFAULT_EMPTY_STRING
    )
}

fun PhotoModel.toPhotoEntity(): PhotoEntity {
    return PhotoEntity(
        idAlbum = idAlbum,
        id = id,
        namePhoto = namePhoto,
        urlPhoto = urlPhoto,
        urlPreviewPhoto = urlPreviewPhoto
    )
}

fun PhotoEntity.toPhotoModel(): PhotoModel {
    return PhotoModel(
        idAlbum = idAlbum,
        id = id,
        namePhoto = namePhoto,
        urlPhoto = urlPhoto,
        urlPreviewPhoto = urlPreviewPhoto
    )
}

fun List<PhotoDTO>.toListPhotoModel(): List<PhotoModel> {
    val listPhotos = arrayListOf<PhotoModel>()
    forEach { listPhotos.add(it.toPhotoModel()) }
    return listPhotos
}

fun List<PhotoModel>.toListPhotoEntity(): List<PhotoEntity> {
    val listPhotos = arrayListOf<PhotoEntity>()
    forEach { listPhotos.add(it.toPhotoEntity()) }
    return listPhotos
}

fun List<PhotoEntity>.toListPhotoModelFromEntity(): List<PhotoModel> {
    val listPhotos = arrayListOf<PhotoModel>()
    forEach { listPhotos.add(it.toPhotoModel()) }
    return listPhotos
}