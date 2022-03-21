package com.example.myapplication.com.example.myapplication.webService.retrofit

data class User(
    val `data`: SingleUserValue,
    val support: UserSupport
)

data class SingleUserValue(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)

data class UserSupport(
    val text: String,
    val url: String
)
