package com.example.myapplication.webService.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ConstantValue.Companion.BaseURL
import com.example.myapplication.com.example.myapplication.webService.UserID
import com.example.myapplication.com.example.myapplication.webService.retrofit.User
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.chap4_activity_single_user.user_profile_email
import kotlinx.android.synthetic.main.chap4_activity_single_user.user_profile_image
import kotlinx.android.synthetic.main.chap4_activity_single_user.user_profile_name
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class SingleUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap4_activity_single_user)

        Thread {
            getSingleUser(intent.getIntExtra(UserID,1))
        }.start()
    }

    private fun getSingleUser(userID: Int) {
        val url = URL("${BaseURL}api/users/$userID")
        (url.openConnection() as HttpURLConnection).apply {
            requestMethod = "GET"
            if (responseCode == 200) {
                BufferedReader(InputStreamReader(inputStream)).use {
                    val response = it.readText()
                    val gson = Gson()
                    val userData = gson.fromJson(response, User::class.java)
                    user_profile_email.text = userData.data.email
                    user_profile_name.text =
                        "${userData.data.first_name} ${userData.data.last_name}"
                    runOnUiThread {
                        Picasso.get().load(userData.data.avatar).into(user_profile_image)
                    }
                }
            } else {
                runOnUiThread {
                    Toast.makeText(applicationContext, "Sorry User Not Found", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

}