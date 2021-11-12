package com.nasa.space.features.photo.common.data

import io.reactivex.rxjava3.core.Single
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import java.util.*

class PhotoRepositoryTest {

    private val photoApiService: PhotoApiService = mock(PhotoApiService::class.java)

    private val photos: Photos = arrayListOf(
        Photo(title = "Milky way", clickedOn = Date(989989109)),
        Photo(title = "Needle galaxy", clickedOn = Date(989989102))
    )

    @Test
    fun `verify successful api call for getting photos returns the data`() {

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

    @Test
    fun `verify that bookmarked photos are marked in the model`() {
        //given
        bookmarks.add(Date(989989109))

        //when
        `when`(photoApiService.getPhotos())
            .thenReturn(Single.just(photos))


        //when
        PhotoRepository(photoApiService).getPhotos()
            //then
            .test()
            .assertValue(photos)
            .assertComplete()

        //them
        assertThat(photos.first().isBookmarked, `is`(true))
        assertThat(photos[1].isBookmarked, `is`(false))

    }
}