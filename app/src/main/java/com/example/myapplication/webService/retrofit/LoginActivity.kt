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
import com.example.myapplication.webService.retrofit.ManualJsonParseActivity
import kotlinx.android.synthetic.main.activity_chap4_login.btnJson
import kotlinx.android.synthetic.main.activity_chap4_login.btnLogin
import kotlinx.android.synthetic.main.activity_chap4_login.et_enter_name
import kotlinx.android.synthetic.main.activity_chap4_login.et_enter_password
import org.json.JSONObject
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

class LoginActivity : AppCompatActivity() {
    val bool: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chap4_login)
        setListener()
        apiCall()
    }

    private fun validationSuccess(): Boolean {
        val etEmail: EditText = findViewById(R.id.et_enter_name)
        val etPassword: EditText = findViewById(R.id.et_enter_password)

        var boolSuccess: Boolean = true

        if (etEmail.text.toString().isEmpty()) {
            etEmail.error = R.string.email_req.toString()
            etEmail.requestFocus()
            boolSuccess = false
        } else if (etPassword.text.toString().trim().isEmpty()) {
            etPassword.error = R.string.password_req.toString()
            etPassword.requestFocus()
            boolSuccess = false
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
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.text).matches()) {
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
        btnJson.setOnClickListener {
            val intent = Intent(this@LoginActivity, ManualJsonParseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun apiCall() {
        btnLogin.setOnClickListener {
            if (validationSuccess()) {
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