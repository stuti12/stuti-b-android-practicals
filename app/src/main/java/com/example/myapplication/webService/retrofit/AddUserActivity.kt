package com.example.myapplication.com.example.myapplication.webService.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ReqRes
import kotlinx.android.synthetic.main.chap4_activity_add_user.btnSave

class AddUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap4_activity_add_user)
        callApi()
    }

    private fun callApi() {
        btnSave.setOnClickListener {
            AndroidNetworking.initialize(this)
            AndroidNetworking.get("https://reqres.in/api/users").build()
                .getAsObject(AddUserActivity::class.java, object : ParsedRequestListener<ReqRes> {
                    override fun onResponse(response: ReqRes) {

                    }

                    override fun onError(anError: ANError?) {
                    }
                })
        }
    }
}