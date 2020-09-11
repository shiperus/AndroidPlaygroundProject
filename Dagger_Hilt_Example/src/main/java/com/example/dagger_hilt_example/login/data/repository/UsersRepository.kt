package com.example.dagger_hilt_example.login.data.repository

import com.example.dagger_hilt_example.login.data.responsemodel.User

interface UsersRepository {
    suspend fun getUsers(): List<User>
}