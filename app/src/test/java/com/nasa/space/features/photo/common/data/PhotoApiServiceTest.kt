package com.nasa.space.features.photo.common.data

import com.google.gson.Gson
import com.nasa.space.common.Utils
import org.junit.Test

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
}