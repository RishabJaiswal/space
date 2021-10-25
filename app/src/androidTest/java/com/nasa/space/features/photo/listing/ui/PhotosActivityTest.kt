package com.nasa.space.features.photo.listing.ui

import androidx.test.ext.junit.rules.activityScenarioRule
import com.adevinta.android.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.nasa.space.R
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.RuleChain

@HiltAndroidTest
class PhotosActivityTest {

    private val hiltAndroidRule = HiltAndroidRule(this)
    private val activityRule = activityScenarioRule<PhotosActivity>()

    @get:Rule
    val rules = RuleChain
        .outerRule(hiltAndroidRule)
        .around(activityRule)

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun whenScreenIsOpen_thenPhotosFetchIsSuccess() {
        assertDisplayedAtPosition(
            R.id.list_photos,
            0,
            R.id.title,
            "Starburst Galaxy M94 from Hubble"
        )
    }
}
