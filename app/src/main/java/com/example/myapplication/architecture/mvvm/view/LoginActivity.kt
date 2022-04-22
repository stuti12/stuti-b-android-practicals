package com.example.myapplication.architecture.mvvm.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myapplication.R
import com.example.myapplication.architecture.getCustomText
import com.example.myapplication.architecture.mvvm.viewmodel.LoginViewModel
import com.example.myapplication.databinding.ActivityArchitectureMvvmLoginBinding
import kotlinx.android.synthetic.main.activity_architecture_mvvm_login.tvinverse

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArchitectureMvvmLoginBinding
    private val loginmodel: LoginViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_architecture_mvvm_login)
        setData()
    }

    private fun setData() {
        binding.loginmodel = loginmodel
        binding.lifecycleOwner = this

        loginmodel.pswd.observe(this){
           binding.tvDontHaveAnAccount.text = loginmodel.pswd.value
            Toast.makeText(this,tvinverse.getCustomText(),Toast.LENGTH_LONG).show()
        }
    }
}

