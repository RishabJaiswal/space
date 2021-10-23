package com.nasa.space.common

/**
 * Model to present state of result.
 * */
abstract class Result<T> (val data: T? = null) {
    fun isLoading() = this is Loading
    fun hasData() = data != null
}

class Default<T>(data: T? = null): Result<T>(data)
class Loading<T>(data: T? = null): Result<T>(data)
class Success<T>(data: T? = null): Result<T>(data)
class Error<T>(data: T? = null): Result<T>(data)