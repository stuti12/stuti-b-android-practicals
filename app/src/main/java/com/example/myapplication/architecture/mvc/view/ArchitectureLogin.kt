package com.example.myapplication.architecture.mvc.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.architecture.controller.LoginController
import com.example.myapplication.architecture.controller.LoginControllerInterface
import com.example.myapplication.architecture.mvp.view.ArchitectureSignup
import com.example.myapplication.databinding.ActivityArchitectureLoginBinding

class ArchitectureLogin : AppCompatActivity(), LoginView {
    private lateinit var binding: ActivityArchitectureLoginBinding
    var loginPresenter: LoginControllerInterface? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchitectureLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }

    private fun setListener() {
        loginPresenter = LoginController(this)

        binding.btnSignIn.setOnClickListener {
            (loginPresenter as LoginController).OnLogin(
                binding.etUserName?.text.toString(),
                binding.etPassword?.text.toString().trim()
            )
        }

        binding.tvDontHaveAnAccount.setOnClickListener {
            val intent = Intent(this@ArchitectureLogin, ArchitectureSignup::class.java)
            startActivity(intent)
        }
    }

    override fun OnLoginSuccess(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun OnLoginError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}