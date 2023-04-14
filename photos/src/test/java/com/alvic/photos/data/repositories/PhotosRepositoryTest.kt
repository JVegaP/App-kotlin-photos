package com.alvic.photos.data.repositories

import com.alvic.photos.data.datasource.IPhotosLocalDataSource
import com.alvic.photos.data.datasource.IPhotosRemoteDataSource
import com.alvic.photos.data.datasource.PhotosLocalDataSource
import com.alvic.photos.data.datasource.PhotosRemoteDataSource
import com.alvic.photos.data.models.PhotoModel
import com.alvic.photos.domain.repositories.IPhotosRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import org.mockito.Mockito.*

class PhotosRepositoryTest {
    private val mockPhotosRemoteDataSource : IPhotosRemoteDataSource = mock(PhotosRemoteDataSource::class.java)
    private val mockPhotosLocalDataSource : IPhotosLocalDataSource = mock(PhotosLocalDataSource::class.java)
    private val photosRepository: IPhotosRepository = PhotosRepository (
        photosRemoteDataSource = mockPhotosRemoteDataSource,
        photosLocalDataSource = mockPhotosLocalDataSource
    )

    private val photos = arrayListOf<PhotoModel>()
    private val photoTestUser = PhotoModel(
        id = 1,
        idAlbum = 1,
        namePhoto = "Photo",
        urlPhoto = "http://www.photo.com",
        urlPreviewPhoto = "http://www.photo.com"
    )
    private val photoTestAdmin = PhotoModel(
        id = 1,
        idAlbum = 2,
        namePhoto = "Photo admin",
        urlPhoto = "http://www.photoad.com",
        urlPreviewPhoto = "http://www.photoad.com"
    )

    @Before
    fun before() {
        photos.add(photoTestUser)
        photos.add(photoTestAdmin)
    }

    @Test
    fun getAllPhotosWhenIsNotInternetAndLocalEmpty() {
        runBlocking {
            `when`(mockPhotosLocalDataSource.getPhotos()).thenReturn(emptyList())
            val result = photosRepository.getPhotos(isConnect = false)
            assertEquals(0,result.size)
            verify(mockPhotosLocalDataSource).getPhotos()
        }
    }

    @Test
    fun getAllPhotosWhenIsNotInternetAndLocalIsNotEmpty() {
        runBlocking {
            `when`(mockPhotosLocalDataSource.getPhotos()).thenReturn(photos)
            val result = photosRepository.getPhotos(isConnect = false)
            assertEquals(2,result.size)
            assertEquals(photos, result)
            verify(mockPhotosLocalDataSource).getPhotos()
        }
    }

    @Test
    fun getAllPhotosWhenIsInternetAndDataIsNotEmpty() {
        runBlocking {
            `when`(mockPhotosRemoteDataSource.getPhotos()).thenReturn(photos)
            val result = photosRepository.getPhotos(isConnect = true)
            assertEquals(2,result.size)
            assertEquals(photos, result)
            verify(mockPhotosLocalDataSource).savePhotos(photos = photos)
            verify(mockPhotosRemoteDataSource).getPhotos()
        }
    }

}