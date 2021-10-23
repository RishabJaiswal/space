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

    @Test
    fun `verify method to check if any result state contains data `() {
        //default
        assertThat(Default("").hasData(), `is`(true))
        assertThat(Default<Any>().hasData(), `is`(false))

        //loading
        assertThat(Loading("").hasData(), `is`(true))
        assertThat(Loading<Any>().hasData(), `is`(false))

        //success
        assertThat(Success("").hasData(), `is`(true))
        assertThat(Success<Any>().hasData(), `is`(false))

        //error
        assertThat(Error("").hasData(), `is`(true))
        assertThat(Error<Any>().hasData(), `is`(false))
    }
}