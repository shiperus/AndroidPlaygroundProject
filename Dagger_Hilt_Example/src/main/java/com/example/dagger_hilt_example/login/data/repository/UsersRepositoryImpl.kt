package com.example.dagger_hilt_example.login.data.repository

import com.example.dagger_hilt_example.login.data.responsemodel.User
import com.example.dagger_hilt_example.login.data.remote.UsersApi
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    private val usersApi: UsersApi
): UsersRepository {
    override suspend fun getUsers(): List<User> {
        return usersApi.getUsers()
    }
}