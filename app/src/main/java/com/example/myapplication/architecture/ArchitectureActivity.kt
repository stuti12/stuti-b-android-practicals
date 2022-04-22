package com.example.myapplication.architecture

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.architecture.mvc.view.ArchitectureLogin
import com.example.myapplication.architecture.mvp.view.ArchitectureSignup
import com.example.myapplication.architecture.mvvm.view.LoginActivity
import kotlinx.android.synthetic.main.activity_architecture.btnMVC
import kotlinx.android.synthetic.main.activity_architecture.btnMVP
import kotlinx.android.synthetic.main.activity_architecture.btnMVVM

class ArchitectureActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_architecture)
        setListener()
    }

    private fun setListener() {
        btnMVC.setOnClickListener {
            val intent = Intent(this@ArchitectureActivity, ArchitectureLogin::class.java)
            startActivity(intent)
        }

        btnMVP.setOnClickListener {
            val intent = Intent(this@ArchitectureActivity, ArchitectureSignup::class.java)
            startActivity(intent)
        }

        btnMVVM.setOnClickListener {
            val intent = Intent(this@ArchitectureActivity, LoginActivity::class.java)
            startActivity(intent)
        }

    }
}