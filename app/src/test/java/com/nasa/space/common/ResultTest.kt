package com.nasa.space.common

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNull
import org.junit.Test

class ResultTest {

    private val error = NullPointerException()

    @Test
    fun `verify method to check if result is loading`() {
        assertThat(Default<Any>().isLoading(), `is`(false))
        assertThat(Loading<Any>().isLoading(), `is`(true))
        assertThat(Success<Any>().isLoading(), `is`(false))
        assertThat(Error<Any>(throwable = error).isLoading(), `is`(false))
    }

    @Test
    fun `verify method to check if result is error`() {
        assertThat(Default<Any>().isError(), `is`(false))
        assertThat(Loading<Any>().isError(), `is`(false))
        assertThat(Success<Any>().isError(), `is`(false))
        assertThat(Error<Any>(throwable = error).isError(), `is`(true))
    }

    @Test
    fun `verify method to check if result is success`() {
        assertThat(Default<Any>().isSuccess(), `is`(false))
        assertThat(Loading<Any>().isSuccess(), `is`(false))
        assertThat(Success<Any>().isSuccess(), `is`(true))
        assertThat(Error<Any>(throwable = error).isSuccess(), `is`(false))
    }

    @Test
    fun `verify if result states has valid data`() {
        //given
        val default = Default("Hello")
        val loading = Loading("Obvious")
        val success = Success("I love Craftspeople")
        val error = Error("!", throwable = error)

        //when //then
        assertThat(default.data, `is`("Hello"))
        assertThat(loading.data, `is`("Obvious"))
        assertThat(success.data, `is`("I love Craftspeople"))
        assertThat(error.data, `is`("!"))
    }

    @Test
    fun `verify if states have valid throwable`() {
        //given
        val default = Default("")
        val loading = Loading("")
        val success = Success("")
        val error = Error("", throwable = error)

        //when //then
        assertNull(default.getError())
        assertNull(loading.getError())
        assertNull(success.getError())
        assertThat(
            error.getError(),
            instanceOf(java.lang.NullPointerException::class.java)
        )
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
        assertThat(Error<Any>(throwable = error).hasData(), `is`(false))
    }

    @Test
    fun `verify result states equality`() {
        assertThat(Default(""), `is`(Default("")))
        assertThat(Loading(""), `is`(Loading("")))
        assertThat(Success(""), `is`(Success("")))
        assertThat(
            Error("", throwable = error),
            `is`(Error("", throwable = error))
        )
    }
}