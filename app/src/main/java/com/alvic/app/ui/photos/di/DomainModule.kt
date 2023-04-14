package com.alvic.app.ui.photos.di

import com.alvic.photos.data.repositories.PhotosRepository
import com.alvic.photos.domain.useCases.GetPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {
    @Provides
    fun provideGetPhotos(photosRepository: PhotosRepository) =
        GetPhotosUseCase(photosRepository = photosRepository)
}