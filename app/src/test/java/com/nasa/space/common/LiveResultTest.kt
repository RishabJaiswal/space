package com.nasa.space.common

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LiveResultTest {

    private val error = NullPointerException()

    @Test
    fun `verify method to check if result is loading`() {
        assertThat(
            LiveResult<Any>(Default()).isLoading(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isLoading(),
            `is`(true)
        )
        assertThat(
            LiveResult<Any>(Success()).isLoading(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isLoading(),
            `is`(false)
        )
    }

    @Test
    fun `verify method to check if result is error`() {
        assertThat(
            LiveResult<Any>(Default()).isError(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isError(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Success()).isError(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isError(),
            `is`(true)
        )
    }

    @Test
    fun `verify method to check if result is success`() {
        assertThat(
            LiveResult<Any>(Default()).isSuccess(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isSuccess(),
            `is`(false)
        )
        assertThat(
            LiveResult<Any>(Success()).isSuccess(),
            `is`(true)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isSuccess(),
            `is`(false)
        )
    }
}