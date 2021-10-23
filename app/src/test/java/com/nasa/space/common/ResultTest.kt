package com.nasa.space.common

import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat

class ResultTest {
    @Test
    fun `verify method to check if result is loading`() {
        assertThat(Default<Any>().isLoading(), `is`(false))
        assertThat(Loading<Any>().isLoading(), `is`(true))
        assertThat(Success<Any>().isLoading(), `is`(false))
        assertThat(Error<Any>().isLoading(), `is`(false))
    }
}