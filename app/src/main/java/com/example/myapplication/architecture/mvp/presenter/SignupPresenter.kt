package com.example.myapplication.architecture.mvp.presenter

import com.example.myapplication.R
import com.example.myapplication.architecture.model.SignupUserInterface
import com.example.myapplication.architecture.mvp.view.SignupView
import com.example.myapplication.architecture.presenter.SignupPresenterInterface

class SignupPresenter(internal var iSignupView: SignupView) : SignupPresenterInterface {
    override fun onSignup(name: String, phone: String, email: String, pswd: String) {
        val user = SignupUserInterface(name,phone,email,pswd)
        val signupCode = user.isDataValid()
        if(signupCode == 0)
            iSignupView.onSignupFail(R.string.emptyUsernameError.toString())
        else if(signupCode == 1)
            iSignupView.onSignupFail(R.string.phone_length.toString())
        else if(signupCode == 2)
            iSignupView.onSignupFail(R.string.emptyUsernameError.toString())
        else if(signupCode == 3)
            iSignupView.onSignupFail(R.string.invalidUsernameError.toString())
        else if(signupCode == 4)
            iSignupView.onSignupFail(R.string.invalidPasswordError.toString())
        else
            iSignupView.onSignupSuccess(R.string.success.toString())

    }

}