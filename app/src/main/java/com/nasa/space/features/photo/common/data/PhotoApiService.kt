package com.nasa.space.features.photo.common.data

import com.google.gson.GsonBuilder
import com.nasa.space.common.Utils
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

/**
 * creating an emulating api service by getting data locally
 **/
class PhotoApiService(
    private val dataSource: String = "/jsons"
) {

    @Inject constructor(): this( "/jsons")

    fun getPhotos(): Single<Photos> {
        val gson = GsonBuilder().create()
        return Single.fromCallable {
            val photosJson = Utils.geFileAsString(this, "$dataSource/photos.json")
            gson.fromJson(photosJson, photosType)
        }
    }
}