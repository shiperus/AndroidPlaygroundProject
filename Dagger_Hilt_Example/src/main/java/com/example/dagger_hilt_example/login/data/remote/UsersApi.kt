package com.example.dagger_hilt_example.login.data.remote

import com.example.dagger_hilt_example.login.data.responsemodel.User
import retrofit2.http.GET

interface UsersApi {

    @GET("users")
    suspend fun getUsers(): List<User>

}