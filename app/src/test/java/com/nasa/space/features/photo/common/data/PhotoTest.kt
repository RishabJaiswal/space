package com.nasa.space.features.photo.common.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nasa.space.common.utils.Utils
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import java.text.SimpleDateFormat


class PhotoTest {

    private lateinit var gson: Gson

    @Before
    fun setup() {
        gson = GsonBuilder()
            .setDateFormat("yyyy-mm-dd")
            .create()
    }

    @Test
    fun `verify deserialization of Photo data model`() {
        //given
        val photoJson = Utils.geFileAsString(this, "/jsons/Photo.json")
        //when
        val photo = gson.fromJson(photoJson, Photo::class.java)

        //then
        assertThat(photo.title, `is`("M33: The Triangulum Galaxy"))
        assertThat(photo.explanation, `is`("This is a small detail"))
        assertThat(photo.copyrightOwner, `is`("Rui Liao"))
        assertThat(photo.isBookmarked, `is`(false))
        assertThat(
            photo.thumbnailUrl,
            `is`("https://apod.nasa.gov/apod/image/1912/M33-HaLRGB-RayLiao1024.jpg")
        )
        assertThat(
            photo.hdUrl,
            `is`("https://apod.nasa.gov/apod/image/1912/M33-HaLRGB-RayLiao.jpg")
        )

        //assertion on date
        val dateFormat = SimpleDateFormat("yyyy-mm-dd")
        val expectedDate = dateFormat.parse("2019-12-31")
        assertThat(photo.clickedOn, `is`(expectedDate))
    }
}