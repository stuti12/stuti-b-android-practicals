package com.example.myapplication.architecture.controller

import com.example.myapplication.R
import com.example.myapplication.architecture.Constants
import com.example.myapplication.architecture.mvc.models.UserInterface
import com.example.myapplication.architecture.mvc.models.UserModel
import com.example.myapplication.architecture.mvc.view.LoginView

interface LoginControllerInterface {
    fun OnLogin(email: String?, password: String?)
}

class LoginController(
    private val loginView: LoginView
):LoginControllerInterface {

    override fun OnLogin(email: String?, password: String?) {
        val user = UserModel(email, password)
        val loginCode = user.isValid()

        when (loginCode) {
            Constants.ZERO -> {
                loginView.OnLoginError(R.string.emptyUsernameError.toString());
            }
            Constants.ONE -> {
                loginView.OnLoginError(R.string.invalidUsernameError.toString());
            }
            Constants.TWO -> {
                loginView.OnLoginError(R.string.password.toString());
            }
            Constants.THREE -> {
                loginView.OnLoginError(R.string.invalidPasswordError.toString());
            }
            else -> {
                loginView.OnLoginSuccess(R.string.success.toString());
            }
        }

    }
}