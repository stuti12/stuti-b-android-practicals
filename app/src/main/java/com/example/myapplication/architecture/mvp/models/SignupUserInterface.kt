package com.example.myapplication.architecture.mvp.models

interface iSignupUser {
    val name: String
    val phone:String
    val email: String
    val password: String
    fun isDataValid(): Int
}