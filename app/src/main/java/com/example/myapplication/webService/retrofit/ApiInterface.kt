package com.example.myapplication.com.example.myapplication.webService.retrofit

import android.text.Editable
import com.example.myapplication.com.example.myapplication.webService.ConstantValue
import com.example.myapplication.com.example.myapplication.webService.ReqRes
import com.example.myapplication.com.example.myapplication.webService.retrofit.dataclass.LoginRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface ApiInterface {
    @POST("/api/login")
    fun logInApi(@Body loginRequest: Editable?, text: Editable?): retrofit2.Call<LoginRequest>

    @GET("/api/users?delay=3")
    fun allUserApi(): retrofit2.Call<ReqRes>

    @POST("users")
    fun createPost(@Body dataModal: DataModal): retrofit2.Call<PostResponse?>

   companion object {
       val retrofit = Retrofit.Builder().baseUrl(ConstantValue.BaseURL)
           .addConverterFactory(GsonConverterFactory.create()).build()

   }
}

