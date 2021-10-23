package com.nasa.space.common

import org.junit.Assert.*
import org.junit.Test

class UtilsTest {
    @Test
    fun `verify utility method to get file content as string`() {
        //given
        val filePath = "/dummy.txt"
        //when
        val fileContent = Utils.geFileAsString(this, filePath)
        //then
        assertEquals("hello Obvious", fileContent)
    }
}