package com.nasa.space.features.photo.common.data

import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import com.nasa.space.common.Result
import java.lang.reflect.Type
import java.util.*

typealias Photos = List<Photo>
typealias PhotosResult = Result<Photos>

val photosType: Type = object : TypeToken<Photos>() {}.type

/**
 * IMPORTANT: since scale of application is fairly small
 * using single class for the data & ui models of photo
 * */
data class Photo(
    @SerializedName("title")
    val title: String = "",

    @SerializedName("explanation")
    val explanation: String = "",

    @SerializedName("url")
    val thumbnailUrl: String = "",

    @SerializedName("hdurl")
    val hdUrl: String = "",

    @SerializedName("copyright")
    val copyrightOwner: String = "",

    @SerializedName("date")
    val clickedOn: Date? = null
)