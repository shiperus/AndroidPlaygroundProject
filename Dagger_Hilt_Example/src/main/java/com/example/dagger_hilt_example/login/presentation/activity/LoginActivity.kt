package com.example.dagger_hilt_example.login.presentation.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.dagger_hilt_example.R
import com.example.dagger_hilt_example.base.util.coroutine.Fail
import com.example.dagger_hilt_example.base.util.coroutine.Success
import com.example.dagger_hilt_example.login.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        observeLoginData()
    }

    private fun observeLoginData() {
        viewModel.loginStatusLiveData.observe(this, Observer { result ->
            when (result) {
                is Success -> {
                    onSuccessLogin()
                }
                is Fail -> {
                    onFailLogin(result.throwable)
                }
            }
        })
    }

    private fun onFailLogin(throwable: Throwable) {
        showToaster(throwable.message ?: "")
    }

    private fun onSuccessLogin() {
        showToaster("Success Login")
    }

    private fun showToaster(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun initView() {
        btn_login?.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val userName = et_username?.text.toString()
        viewModel.login(userName)
    }

}
