package com.nasa.space.features.photo.listing

import androidx.lifecycle.ViewModel
import com.nasa.space.common.LiveResult
import com.nasa.space.common.Loading
import com.nasa.space.common.extensions.addTo
import com.nasa.space.common.extensions.subscribeOnBackObserverOnMain
import com.nasa.space.features.photo.common.data.PhotoRepository
import com.nasa.space.features.photo.common.data.Photos
import io.reactivex.rxjava3.disposables.CompositeDisposable

class PhotosViewModel(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    val photosLiveResult = LiveResult<Photos>(Loading())
    private val disposables = CompositeDisposable()

    fun getPhotos() {
        photoRepository.getPhotos()
            .subscribeOnBackObserverOnMain()
            .doOnSubscribe { photosLiveResult.loading() }
            .subscribe(photosLiveResult::success) { error ->
                photosLiveResult.error(throwable = error)
            }
            .addTo(disposables)
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}