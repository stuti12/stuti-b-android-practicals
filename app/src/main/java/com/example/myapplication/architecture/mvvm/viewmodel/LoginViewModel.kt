package com.example.myapplication.architecture.mvvm.viewmodel

import androidx.annotation.DrawableRes
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.architecture.mvvm.model.User

class LoginViewModel : ViewModel() {
    var data = MutableLiveData<User>()
    var email = MutableLiveData("")
    var pswd = MutableLiveData("")
    val message = MutableLiveData("Hello Stuti")
    fun onLoginClick(){
       data.value = User(email.value, pswd.value, message.value)
    }
}

data class Userinfo(var name: String, @DrawableRes val userImage: Int)

