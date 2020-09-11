package com.example.dagger_hilt_example.login.presentation.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.example.dagger_hilt_example.base.util.ErrorHandlerException
import com.example.dagger_hilt_example.base.util.coroutine.Result
import com.example.dagger_hilt_example.base.util.coroutine.Success
import com.example.dagger_hilt_example.login.domain.usecase.GetUsersUseCase
import com.example.dagger_hilt_example.base.util.coroutine.CoroutineDispatcherProvider
import com.example.dagger_hilt_example.base.util.coroutine.Fail
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel @ViewModelInject constructor(
    private val dispatcherProvider: CoroutineDispatcherProvider,
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel(), LifecycleObserver {

    val loginStatusLiveData: LiveData<Result<Boolean>>
        get() = _loginStatusLiveData
    private val _loginStatusLiveData = MutableLiveData<Result<Boolean>>()

    fun login(userName: String) {
        viewModelScope.launch {
            try {
                if (isLoginDataNotEmpty(userName)) {
                    val loginResult = withContext(dispatcherProvider.io()) {
                        isUserDataMatch(userName)
                    }
                    _loginStatusLiveData.postValue(Success(loginResult))
                } else {
                    throw ErrorHandlerException("Username must not empty")
                }
            } catch (e: Throwable) {
                _loginStatusLiveData.postValue(Fail(e))
            }
        }
    }

    private suspend fun isUserDataMatch(userName: String): Boolean {
        val listUser = getUsersUseCase.execute()
        val isUserMatch = listUser.any { it.userName == userName }
        if (isUserMatch)
            return true
        else
            throw ErrorHandlerException("Username not match")
    }

    private fun isLoginDataNotEmpty(userName: String): Boolean {
        return userName.isNotEmpty()
    }

}