package com.nasa.space.common.utils

import java.io.FileNotFoundException
import java.nio.charset.StandardCharsets

class Utils {
    companion object {

        @Throws(exceptionClasses = [FileNotFoundException::class, NullPointerException::class])
        fun geFileAsString(classLoaderObject: Any, filePath: String): String {
            val resource = classLoaderObject.javaClass.getResourceAsStream(filePath)
            return String(resource!!.readBytes(), StandardCharsets.UTF_8)
        }
    }
}