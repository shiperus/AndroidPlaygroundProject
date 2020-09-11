package com.example.dagger_hilt_example.base.util.coroutine

sealed class Result<out T>
data class Success<T>(val data: T): Result<T>()
data class Fail(val throwable: Throwable): Result<Nothing>()
