package com.nasa.space.common

import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class LiveResultTest {

    private val error = NullPointerException()

    @Test
    fun `verify method to check if result is loading`() {
        assertThat(
            LiveResult<Any>(Default()).isLoading(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isLoading(),
            CoreMatchers.`is`(true)
        )
        assertThat(
            LiveResult<Any>(Success()).isLoading(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isLoading(),
            CoreMatchers.`is`(false)
        )
    }

    @Test
    fun `verify method to check if result is error`() {
        assertThat(
            LiveResult<Any>(Default()).isError(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isError(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Success()).isError(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isError(),
            CoreMatchers.`is`(true)
        )
    }

    @Test
    fun `verify method to check if result is success`() {
        assertThat(
            LiveResult<Any>(Default()).isSuccess(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Loading()).isSuccess(),
            CoreMatchers.`is`(false)
        )
        assertThat(
            LiveResult<Any>(Success()).isSuccess(),
            CoreMatchers.`is`(true)
        )
        assertThat(
            LiveResult<Any>(Error(throwable = error)).isSuccess(),
            CoreMatchers.`is`(false)
        )
    }
}