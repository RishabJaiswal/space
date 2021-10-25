package com.nasa.space.features.photo.details.ui

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.nasa.space.features.photo.common.data.Photo
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PhotoDetailsFragmentTest {
    @Test
    fun ass() {
        //given
        val photo = Photo(
            title = "Photo",
            copyrightOwner = "me",
            explanation = "Space is awesome"
        )

        //when
        val scenario = launchFragmentInContainer {
            PhotoDetailsFragment(photo)
        }

        //then
        assertDisplayed("Photo")
        assertDisplayed("me")
        assertDisplayed("Space is awesome")
    }
}