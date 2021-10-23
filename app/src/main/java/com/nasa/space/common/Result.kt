package com.nasa.space.common

/**
 * Model to present state of result.
 * */
abstract class Result<T> (val data: T? = null) {
    fun isLoading() = this is Loading
}

class Default<T>: Result<T>()
class Loading<T>: Result<T>()
class Success<T>: Result<T>()
class Error<T>: Result<T>()