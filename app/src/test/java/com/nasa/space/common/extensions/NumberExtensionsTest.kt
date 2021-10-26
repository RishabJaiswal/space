package com.nasa.space.common.extensions

import android.util.DisplayMetrics
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.Test

class NumberExtensionsTest {

    private val displayMetrics = DisplayMetrics().apply {
        density = 2f
    }

    @Test
    fun `verify dp to pixels conversion`() {
        val marginInPixels = 16.dpToPx(displayMetrics)
        assertThat(marginInPixels, `is`(32))
    }
}