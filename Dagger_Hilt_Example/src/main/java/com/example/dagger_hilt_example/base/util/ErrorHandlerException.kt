package com.example.dagger_hilt_example.base.util

data class ErrorHandlerException(
    val errorMessage: String
) : Throwable(errorMessage) {
}