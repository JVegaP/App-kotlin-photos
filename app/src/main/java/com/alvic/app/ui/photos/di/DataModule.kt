package com.alvic.app.ui.photos.di

import com.alvic.app.ui.photos.room.AppDatabase
import com.alvic.photos.data.api.PhotosApi
import com.alvic.photos.data.datasource.IPhotosLocalDataSource
import com.alvic.photos.data.datasource.IPhotosRemoteDataSource
import com.alvic.photos.data.datasource.PhotosLocalDataSource
import com.alvic.photos.data.datasource.PhotosRemoteDataSource
import com.alvic.photos.data.repositories.PhotosRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun providePhotosRepository(
        photosRemoteDataSource: IPhotosRemoteDataSource,
        photosLocalDataSource: IPhotosLocalDataSource
    ) = PhotosRepository(
        photosRemoteDataSource = photosRemoteDataSource,
        photosLocalDataSource = photosLocalDataSource
    )

    @Provides
    fun providePhotosRemoteDatasource(photosApi: PhotosApi): IPhotosRemoteDataSource =
        PhotosRemoteDataSource(photosApi = photosApi)

    @Singleton
    @Provides
    fun providePhotosLocalRemoteDataSource(db: AppDatabase): IPhotosLocalDataSource =
        PhotosLocalDataSource(db.getPhotosDao())
}