package com.alvic.photos.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
class PhotoEntity (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "albumId") val idAlbum: Int,
    @ColumnInfo(name = "title") val namePhoto: String,
    @ColumnInfo(name = "url") val urlPhoto: String,
    @ColumnInfo(name = "thumbnailUrl") val urlPreviewPhoto: String
)