package com.example.myapplication.com.example.myapplication.webService.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.example.myapplication.R
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
   private lateinit var retrofit : Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        callLoginAPI()
    }

    private fun callLoginAPI() {
       val apiInterface =  getRetrofitObject().create(ApiInterface::class.java)

      val loginRequest = LoginRequest()
        loginRequest.email = "eve.holt@reqres.in"
        loginRequest.password = "cityslicka"
       val loginApi = apiInterface.logInApi(loginRequest)
        loginApi.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>?, response: Response<Any>?) {
                 val body: Any? = response?.body()
            }

            override fun onFailure(call: Call<Any>?, t: Throwable?) {
            }

        })

    }

    private fun getRetrofitObject() : Retrofit {
       val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        val client: OkHttpClient.Builder = OkHttpClient.Builder().addInterceptor(interceptor)
            .addInterceptor(Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("Content-Type","application/json")
                return@Interceptor chain.proceed(builder.build())
            })

        val build = client.build()

            retrofit = Retrofit.Builder().baseUrl("https://reqres.in/")
                .client(build)
                .addConverterFactory(
                    GsonConverterFactory.create()
                ).build()

        return retrofit
    }
}