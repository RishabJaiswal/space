package com.nasa.space.common

import org.junit.Assert.*
import org.junit.Test

class UtilsTest {
    @Test
    fun `verify utility method to get file content as string`() {
        val fileContent = Utils.geFileAsString(this, "/dummy.txt")
        assertEquals("hello Obvious", fileContent)
    }
}