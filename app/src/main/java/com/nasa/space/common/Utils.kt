package com.nasa.space.common

import java.io.File

class Utils {
    companion object {
        fun geFileAsString(classLoaderObject: Any, filePath: String): String {
            val resource = classLoaderObject.javaClass.getResource(filePath)
            val file = File(resource!!.path)
            return file.readText()
        }
    }
}