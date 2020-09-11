package com.example.dagger_hilt_example.base.util.coroutine

import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

object CoroutineDispatcherProviderImpl :
    CoroutineDispatcherProvider {
    override fun main(): CoroutineDispatcher = Dispatchers.Main

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun default(): CoroutineDispatcher = Dispatchers.Default

}