package com.nasa.space.features.photo.common.data

import io.reactivex.rxjava3.core.Single
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.lang.IllegalArgumentException

class PhotoRepositoryTest {

    private val photoApiService: PhotoApiService = mock(PhotoApiService::class.java)

    @Test
    fun `verify successful read call for getting photos returns the data`() {
        //given
        val photos: Photos = arrayListOf(
            Photo(title = "Milky way"),
            Photo(title = "Needle galaxy")
        )
        `when`(photoApiService.getPhotos())
            .thenReturn(Single.just(photos))

        //when
        PhotoRepository(photoApiService).getPhotos()
            //then
            .test()
            .assertValue(photos)
            .assertComplete()
    }

    @Test
    fun `verify unsuccessful api call for getting photos throws an exception`() {
        //given
        val exception = IllegalArgumentException()
        `when`(photoApiService.getPhotos())
            .thenReturn(Single.error(exception))

        //when
        PhotoRepository(photoApiService).getPhotos()
            //then
            .test()
            .assertError(exception.javaClass)
    }
}