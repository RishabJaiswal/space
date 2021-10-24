package com.nasa.space.common

import org.hamcrest.CoreMatchers.`is`
import org.junit.Test
import org.hamcrest.MatcherAssert.assertThat
import org.junit.BeforeClass
import java.lang.NullPointerException

class ResultTest {

    private val error = NullPointerException()

    @Test
    fun `verify method to check if result is loading`() {
        assertThat(Default<Any>().isLoading(), `is`(false))
        assertThat(Loading<Any>().isLoading(), `is`(true))
        assertThat(Success<Any>().isLoading(), `is`(false))
        assertThat(Error<Any>(error = error).isLoading(), `is`(false))
    }

    @Test
    fun `verify method to check if result is error`() {
        assertThat(Default<Any>().isError(), `is`(false))
        assertThat(Loading<Any>().isError(), `is`(false))
        assertThat(Success<Any>().isError(), `is`(false))
        assertThat(Error<Any>(error = error).isError(), `is`(true))
    }

    @Test
    fun `verify method to check if result is success`() {
        assertThat(Default<Any>().isSuccess(), `is`(false))
        assertThat(Loading<Any>().isSuccess(), `is`(false))
        assertThat(Success<Any>().isSuccess(), `is`(true))
        assertThat(Error<Any>(error = error).isSuccess(), `is`(false))
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
        val error = NullPointerException()
        assertThat(Error("", error).hasData(), `is`(true))
        assertThat(Error<Any>(error = error).hasData(), `is`(false))
    }

    @Test
    fun `verify result states equality`() {
        assertThat(Default(""), `is`(Default("")))
        assertThat(Loading(""), `is`(Loading("")))
        assertThat(Success(""), `is`(Success("")))
        assertThat(Error(""), `is`(Error("")))
    }
}