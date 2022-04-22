package com.example.myapplication.architecture.mvvm.model

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable

interface LoginResultCallBacks {
    fun onSuccess(msg: String)
    fun onFail(msg: String)
}
data class LoginUser(val email: String, val password: String) {
   val isDataValid: Boolean
    get() = (!TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length > 6)

}

data class User(val email: String? = "",val password: String? = "",val message: String? = "")
