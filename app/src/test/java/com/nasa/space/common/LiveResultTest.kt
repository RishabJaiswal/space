package com.nasa.space.common

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Assert.assertNull
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class LiveResultTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

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


    @Test
    fun `verify changes in the state of live result`() {
        //given
        val liveResult = LiveResult<String>(Default())

        //when
        liveResult.loading("Hello Obvious")
        ///then
        assertThat(liveResult.isLoading(), `is`(true))
        assertThat(liveResult.getData(), `is`("Hello Obvious"))
        assertNull(liveResult.getError())

        //when
        liveResult.success("I love TDD & clean code")
        ///then
        assertThat(liveResult.isSuccess(), `is`(true))
        assertThat(liveResult.getData(), `is`("I love TDD & clean code"))
        assertNull(liveResult.getError())

        //when
        liveResult.error("!", throwable = error)
        ///then
        assertThat(liveResult.isError(), `is`(true))
        assertThat(liveResult.getData(), `is`("!"))
        assertThat(liveResult.getError(), instanceOf(NullPointerException::class.java))
    }
}