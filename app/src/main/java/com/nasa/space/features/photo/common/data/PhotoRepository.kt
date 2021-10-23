package com.nasa.space.features.photo.common.data

import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PhotoRepository @Inject constructor(
    private val photoApiService: PhotoApiService
) {
    fun getPhotos(): Single<Photos> = photoApiService.getPhotos()
}