package com.example.dagger_hilt_example.login.di.module

import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProvider
import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProviderImpl
import com.example.dagger_hilt_example.login.data.remote.UsersApi
import com.example.dagger_hilt_example.login.data.repository.UsersRepository
import com.example.dagger_hilt_example.login.data.repository.UsersRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
object LoginModule {

    @Provides
    fun provideUsersApi(retrofit: Retrofit): UsersApi{
        return retrofit.create(UsersApi::class.java)
    }

    @Provides
    fun provideUserRepository(usersApi: UsersApi): UsersRepository{
        return UsersRepositoryImpl(usersApi)
    }

    @Provides
    fun provideCoroutineDispatcher(): CoroutineDispatcherProvider {
        return CoroutineDispatcherProviderImpl
    }
}