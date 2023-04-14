package com.alvic.app.ui.photos.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvic.photos.data.models.PhotoModel
import com.alvic.photos.domain.useCases.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase
): ViewModel() {
    val photos = MutableLiveData<List<PhotoModel>>()
    fun getPhotos(isConnect: Boolean) {
        viewModelScope.launch {
            photos.value = getPhotosUseCase.invoke(isConnect = isConnect)
        }
    }
}