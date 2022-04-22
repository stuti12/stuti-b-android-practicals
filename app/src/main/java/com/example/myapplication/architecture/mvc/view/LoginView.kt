package com.example.myapplication.architecture.mvc.view

interface LoginView {
    fun OnLoginSuccess(message: String?)
    fun OnLoginError(message: String?)
}