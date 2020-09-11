package com.example.dagger_hilt_example.base.usecase

interface BaseUseCase<T> {
    suspend fun execute() : T
}