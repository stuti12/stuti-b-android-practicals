package com.example.myapplication.com.example.myapplication.webService.retrofit

import com.example.myapplication.com.example.myapplication.webService.ReqRes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {
   @POST("/api/login")
   fun logInApi(@Body loginRequest: LoginRequest) : Call<Any>
   @GET("/api/users?delay=3")
   fun allUserApi(): Call<ReqRes>
}