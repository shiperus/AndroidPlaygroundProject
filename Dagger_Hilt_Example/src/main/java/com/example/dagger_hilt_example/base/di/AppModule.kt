package com.example.dagger_hilt_example.base.di

import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProvider
import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProviderImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}