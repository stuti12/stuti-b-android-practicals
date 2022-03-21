package com.example.myapplication.webService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_web_service.btnApi
import kotlinx.android.synthetic.main.activity_web_service.btnRetrofit

class WebServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_service)
        setListener()
    }

    private fun setListener() {
        btnApi.setOnClickListener {
            val intent = Intent(this@WebServiceActivity, LoginActivity::class.java)
            startActivity(intent)
        }
        btnRetrofit.setOnClickListener {
            val intent = Intent(this@WebServiceActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}