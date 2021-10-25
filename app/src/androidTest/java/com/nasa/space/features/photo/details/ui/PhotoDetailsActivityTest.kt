package com.nasa.space.features.photo.listing.ui

import android.os.Bundle
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.filters.LargeTest
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.nasa.space.features.photo.details.ui.PhotoDetailsActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain


@LargeTest
@HiltAndroidTest
class PhotoDetailsActivityTest {

    private val hiltAndroidRule = HiltAndroidRule(this)

    private val activityRule = activityScenarioRule<PhotoDetailsActivity>(
        activityOptions = Bundle().apply {
            putInt(PhotoDetailsActivity.PHOTO_POSITION, 1)
        }
    )

    @get:Rule
    val rules: RuleChain = RuleChain
        .outerRule(hiltAndroidRule)
        .around(activityRule)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun whenScreenIsOpen_thenPhotosFetchIsSuccess() {
        assertDisplayed("Starburst Galaxy M94 from Hubble")
    }
}
