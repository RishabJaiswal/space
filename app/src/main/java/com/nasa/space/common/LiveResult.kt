package com.nasa.space.common

import androidx.lifecycle.MutableLiveData

class LiveResult<T>(initialResult: Result<T>) : MutableLiveData<Result<T>>(initialResult) {
    fun isLoading() = this.value?.isLoading() ?: false
    fun isSuccess() = this.value?.isSuccess() ?: false
    fun isError() = this.value?.isError() ?: false
}