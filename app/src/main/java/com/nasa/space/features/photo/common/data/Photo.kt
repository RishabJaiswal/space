package com.nasa.space.features.photo.common.data

import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

typealias Photos = List<Photo>
val photosType: Type = object : TypeToken<Photos>() {}.type

data class Photo(
    @SerializedName("title")
    val title: String = "",

    @SerializedName("explanation")
    val details: String = "",

    @SerializedName("url")
    val thumbnailUrl: String = "",

    @SerializedName("hdurl")
    val hdUrl: String = "",

    @SerializedName("copyright")
    val copyrightOwner: String = "",

    @SerializedName("date")
    val clickedOn: Date? = null
)