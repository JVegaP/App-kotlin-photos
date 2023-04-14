package com.alvic.photos.data.dtos

import com.google.gson.annotations.SerializedName

class PhotoDTO (
    @SerializedName("albumId") val idAlbum: Int?,
    val id: Int?,
    @SerializedName("title") val namePhoto: String?,
    @SerializedName("url") val urlPhoto: String?,
    @SerializedName("thumbnailUrl") val urlPreviewPhoto: String?,
)