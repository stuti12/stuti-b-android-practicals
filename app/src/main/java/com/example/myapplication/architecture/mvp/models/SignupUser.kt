package com.example.myapplication.architecture.model

import android.text.TextUtils
import android.util.Patterns
import com.example.myapplication.architecture.Constants
import com.example.myapplication.architecture.mvp.models.iSignupUser

class SignupUserInterface(override val name: String, override val phone: String, override val email: String, override  val password: String):
    iSignupUser {

    override fun isDataValid(): Int {
        if(TextUtils.isEmpty(name))
           return Constants.ZERO
        if(TextUtils.isEmpty(phone))
            return Constants.ONE
        return if(TextUtils.isEmpty(email))
            Constants.TWO
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            Constants.THREE
        else if(TextUtils.isEmpty(password) || password.length <= 6)
            Constants.FOUR
        else
            Constants.MINUS
    }

}