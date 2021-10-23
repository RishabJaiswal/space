package com.nasa.space.common

/**
 * Model to present state of result.
 * */
sealed class Result<T>(open val data: T? = null) {
    fun isLoading() = this is Loading
    fun hasData() = data != null
}

data class Default<T>(
    override val data: T? = null
) : Result<T>()

data class Loading<T>(
    override val data: T? = null
) : Result<T>()

data class Success<T>(
    override val data: T? = null
) : Result<T>()

data class Error<T>(
    override val data: T? = null
) : Result<T>(data)