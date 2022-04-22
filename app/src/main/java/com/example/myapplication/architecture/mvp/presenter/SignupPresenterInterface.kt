package com.example.myapplication.architecture.presenter

interface SignupPresenterInterface {
    fun onSignup(name: String, phone: String, email: String, pswd: String)
}