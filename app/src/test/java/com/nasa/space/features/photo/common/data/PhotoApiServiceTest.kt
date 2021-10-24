package com.nasa.space.features.photo.common.data

import com.google.gson.Gson
import com.nasa.space.common.utils.Utils
import org.junit.Test
import java.lang.NullPointerException

class PhotoApiServiceTest {

    @Test
    fun `verify successful read call for getting photos returns the data`() {
        //given
        val photosJson = Utils.geFileAsString(this, "/jsons/photos.json")
        val photos = Gson().fromJson<Photos>(photosJson, photosType)

        //when
        PhotoApiService().getPhotos()
            //then
            .test()
            .assertValue(photos)
            .assertComplete()
    }

    @Test
    fun `verify unsuccessful read call for getting photos throws exception`() {
        //given
        val wrongDataSource = "/wrongPath"

        //when
        PhotoApiService(wrongDataSource).getPhotos()
            //then
            .test()
            .assertFailure(NullPointerException::class.java)
    }
}