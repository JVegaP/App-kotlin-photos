package com.alvic.app.ui.photos.di

import android.app.Application
import androidx.room.Room
import android.content.Context
import com.alvic.app.ui.photos.room.AppDatabase
import com.alvic.photos.core.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDataBaseRoom(app: Application) =
        Room.databaseBuilder(app, AppDatabase::class.java, AppConstants.DATABASE_APP_NAME)
            .build()
}