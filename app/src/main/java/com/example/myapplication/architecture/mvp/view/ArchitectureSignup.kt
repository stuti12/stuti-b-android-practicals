package com.example.myapplication.architecture.mvp.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.architecture.mvc.view.ArchitectureLogin
import com.example.myapplication.architecture.mvp.presenter.SignupPresenter
import com.example.myapplication.databinding.ActivityArchitectureSignupBinding

class ArchitectureSignup : AppCompatActivity(), SignupView {
    private lateinit var binding: ActivityArchitectureSignupBinding

    private lateinit var signupPresenter: SignupPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchitectureSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        callSignup()
    }

    fun callSignup() {
       signupPresenter = SignupPresenter(this)
        binding.btnSignUp.setOnClickListener {
            signupPresenter.onSignup(binding.etUserName.text.toString(),binding.etPhone.toString(),binding.etEmail.text.toString(),binding.etPassword.text.toString())
        }
        binding.tvSignIn.setOnClickListener {
            val intent = Intent(this@ArchitectureSignup, ArchitectureLogin::class.java)
            startActivity(intent)
        }
    }

    override fun onSignupSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    override fun onSignupFail(message: String) {
       Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

}