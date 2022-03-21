package com.example.myapplication.com.example.myapplication.webService.retrofit

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.webService.ConstantValue.Companion.BaseURL
import kotlinx.android.synthetic.main.chap4_activity_login.btnLogin
import kotlinx.android.synthetic.main.chap4_activity_login.et_enter_name
import kotlinx.android.synthetic.main.chap4_activity_login.et_enter_password
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {
    val bool: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.chap4_activity_login)
        setListener()
        apiCall()
    }

    fun validationSuccess(): Boolean {
        val etEmail: EditText = findViewById(R.id.et_enter_name)
        val etPassword: EditText = findViewById(R.id.et_enter_password)

        var boolSuccess: Boolean = true
        when {
            etEmail.text.toString().trim() == "" -> {
                etEmail.error = "Email Id Required"
                etEmail.requestFocus()
                boolSuccess = false
            }
            etPassword.text.toString().trim().equals("") -> {
                etPassword.error = "password Required";
                etPassword.requestFocus()
                boolSuccess = false
            }
        }

        boolSuccess
        return boolSuccess
    }

    private fun setListener() {
        et_enter_name.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val etEmail: EditText = findViewById(R.id.et_enter_name)
                if (!etEmail.text.toString().isEmailValid()) {
                    etEmail.error = "Email not valid"
                    etEmail.requestFocus()
                }
            }
        })
        et_enter_password.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (et_enter_password.text!!.length < 8) {
                    et_enter_password.error = "Password length short"
                }
            }
        })
    }

    fun isValidPassword(password: String?): Boolean {
        password?.let {
            val passwordPattern =
                "^(?=.*[a-z])(?=.*[A-Z])(?=\\\\S+\$)$"
            val passwordMatcher = Regex(passwordPattern)
            return passwordMatcher.find(password) != null
        } ?: return false
    }

    fun String.isEmailValid() =
        Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" + "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
        ).matcher(this).matches()

    private fun apiCall() {

        btnLogin.setOnClickListener {
            if (validationSuccess()) {
                //Toast.makeText(this@LoginActivity, "Login", Toast.LENGTH_LONG).show();
                Thread {
                    try {
                        val result = httpPostRequest(
                            username = et_enter_name.text.toString(),
                            password = et_enter_password.text.toString()
                        )
                        if (result) {
                            runOnUiThread {
                                Toast.makeText(this@LoginActivity, "Loggin", Toast.LENGTH_SHORT)
                                    .show()
                                val intent =
                                    Intent(this@LoginActivity, UserListActivity::class.java)
                                startActivity(intent)
                            }
                        } else {
                            runOnUiThread {
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Not logged",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }

                    } catch (ex: Exception) {
                        ex.printStackTrace()
                    }
                }.start()
            }
        }
    }

    private fun httpPostRequest(username: String, password: String): Boolean {
        val credential = JSONObject()
        credential.put("email", username)
        credential.put("password", password)
        val url = URL("${BaseURL}api/login")
        with(url.openConnection() as HttpURLConnection) {
            requestMethod = "POST"
            setRequestProperty("content-type", "application/json")
            val output = OutputStreamWriter(outputStream)
            output.write(credential.toString())
            output.flush()

            println("URL : $url")
            println("Cred : $credential")
            println("Responce Code: $responseCode")

            if (responseCode == 200) {
                val response = inputStream.bufferedReader().use { it.readLine() }
                println("Response $response")
                return true
            } else {
                return false
            }
        }
    }
}

