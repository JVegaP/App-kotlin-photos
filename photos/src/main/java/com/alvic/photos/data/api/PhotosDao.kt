package com.alvic.photos.data.api

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.alvic.photos.data.entities.PhotoEntity

@Dao
interface PhotosDao {
    @Query("SELECT * FROM photos ORDER BY id ASC")
    suspend fun getPhotos(): List<PhotoEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(photos: List<PhotoEntity>)

    @Query("DELETE FROM photos")
    suspend fun deletePhotos()
}