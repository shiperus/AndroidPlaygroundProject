package com.example.dagger_hilt_example.login.domain.usecase

import com.example.dagger_hilt_example.base.usecase.BaseUseCase
import com.example.dagger_hilt_example.login.data.responsemodel.User
import com.example.dagger_hilt_example.login.data.repository.UsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) : BaseUseCase<List<User>>{
    override suspend fun execute(): List<User> {
        return usersRepository.getUsers()
    }
}