package com.nasa.space.features.photo.common.viewmodel

import androidx.lifecycle.ViewModel
import com.nasa.space.common.LiveResult
import com.nasa.space.common.Loading
import com.nasa.space.common.extensions.addTo
import com.nasa.space.common.extensions.subscribeOnBackObserverOnMain
import com.nasa.space.features.photo.common.data.PhotoRepository
import com.nasa.space.features.photo.common.data.Photos
import com.nasa.space.features.photo.common.data.bookmarks
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.*
import javax.inject.Inject

@HiltViewModel
class PhotosViewModel @Inject constructor(
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

    fun getPhotoUrl(position: Int): String? {
        return photosLiveResult.getData()?.let { photos ->
            photos[position].hdUrl
        }
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    fun bookmarkPhoto(date: Date) {
        bookmarks.add(date)
    }
}