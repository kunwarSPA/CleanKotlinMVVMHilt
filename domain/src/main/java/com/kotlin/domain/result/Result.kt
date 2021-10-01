package com.kotlin.domain.result

sealed class Result<T> {
    class Loading<T> : Result<T>()
    data class Success<T> (val loginStatus: T) : Result<T>()
    data class Failure<T> (val throwable: Throwable) : Result<T>()
}