package com.example.myapplication.architecture.mvp.view

interface SignupView {
    fun onSignupSuccess(message: String)
    fun onSignupFail(message: String)
}