package com.example.myapplication.architecture.mvc.models
interface UserInterface {
    fun getEmail(): String?
    fun getPassword(): String?
    fun isValid(): Int
}