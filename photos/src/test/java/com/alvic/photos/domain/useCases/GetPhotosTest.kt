package com.alvic.photos.domain.useCases

import com.alvic.photos.data.models.PhotoModel
import com.alvic.photos.data.repositories.PhotosRepository
import com.alvic.photos.domain.repositories.IPhotosRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals
import org.mockito.Mockito.*

class GetPhotosTest {
    private val mockPhotosRepository : IPhotosRepository = mock(PhotosRepository::class.java)
    private val getPhotosUseCase= GetPhotosUseCase (
        mockPhotosRepository
    )

    @Test
    fun getAllPhotosWhenIsSuccessFullyAndIsListEmpty() {
        runBlocking {
            `when`(mockPhotosRepository.getPhotos(isConnect = true)).thenReturn(emptyList())
            val result = getPhotosUseCase.invoke(isConnect = true)
            assertEquals(0,result.size)
            verify(mockPhotosRepository).getPhotos(isConnect = true)
        }
    }

    @Test
    fun getAllPhotosWhenIsSuccessFullyAndData() {
        runBlocking {
            val photos = arrayListOf<PhotoModel>()
            val photoTestUser = PhotoModel(
                id = 1,
                idAlbum = 1,
                namePhoto = "Photo",
                urlPhoto = "http://www.photo.com",
                urlPreviewPhoto = "http://www.photo.com"
            )
            val photoTestAdmin = PhotoModel(
                id = 1,
                idAlbum = 2,
                namePhoto = "Photo admin",
                urlPhoto = "http://www.photoad.com",
                urlPreviewPhoto = "http://www.photoad.com"
            )
            photos.add(photoTestUser)
            photos.add(photoTestAdmin)
            `when`(mockPhotosRepository.getPhotos(isConnect = true)).thenReturn(photos)
            val result = getPhotosUseCase.invoke(isConnect = true)
            assertEquals(2,result.size)
            assertEquals(photos, result)
            verify(mockPhotosRepository).getPhotos(isConnect = true)
        }
    }
}