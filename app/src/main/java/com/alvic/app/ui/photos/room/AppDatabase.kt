package com.alvic.app.ui.photos.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alvic.photos.data.api.PhotosDao
import com.alvic.photos.data.entities.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getPhotosDao(): PhotosDao
}