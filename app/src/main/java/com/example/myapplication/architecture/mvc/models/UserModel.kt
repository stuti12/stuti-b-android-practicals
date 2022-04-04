package com.example.myapplication.architecture.mvc.models

import android.text.TextUtils
import android.util.Patterns
import com.example.myapplication.architecture.Constants

class UserModel(
    private var email: String?,
    private var password: String?
) : UserInterface {

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isValid(): Int {
        if (TextUtils.isEmpty(getEmail()))
            return Constants.ZERO
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return Constants.ONE
        else if (TextUtils.isEmpty(getPassword()))
            return Constants.TWO
        else if (getPassword()?.length!! <= 6)
            return Constants.THREE
        else
            return -1;
    }
}