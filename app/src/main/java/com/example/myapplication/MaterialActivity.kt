package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import kotlinx.android.synthetic.main.activity_material.*
import java.util.regex.Pattern

class MaterialActivity : AppCompatActivity() {
    var pattern = Pattern.compile(".+@.+\\.[a-z]+")
    private val loginBtn: Button = findViewById(R.id.letTheUserLogIn)
    val bool: Boolean = true
    //val toggle: ToggleButton = findViewById(R.id.login_password)
    val etPhone: EditText = findViewById(R.id.login_phone_number_editText)
    private val etPswd: EditText = findViewById(R.id.login_password_editText)
    val checkBox: CheckBox = findViewById(R.id.remember_me)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_material)
       setData()

    }
    private fun setData() {
        loginBtn.setOnClickListener {
            if (validationSuccess())
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show()

        }
        etPswd.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etPswd.text.length < 8) {
                    etPswd.error = "Password length short"
                } else if (bool != isValidPassword(etPswd.text.toString())) {
                    etPswd.error =
                        "Atleast 8 characters and 1 uppercase, 1 number, 1 Special symbol"
                    etPswd.requestFocus()
                    // boolSuccess = false
                }
            }
        })

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
        createAcc.setOnClickListener {
            val intent = Intent(this@MaterialActivity, DisplayToast::class.java)
            startActivity(intent)
            Toast.makeText(this, "Account Create", Toast.LENGTH_SHORT).show()
        }

    }
    fun isValidPassword(password: String?): Boolean {
        password?.let {
            val passwordPattern =
                "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$"
            val passwordMatcher = Regex(passwordPattern)

            return passwordMatcher.find(password) != null
        } ?: return false
    }

    fun validationSuccess(): Boolean {
        if (etPhone.text.toString().trim() == "") {
            etPhone.error = "Phone Required";
            etPhone.requestFocus()
            return false
        }
        if (etPswd.getText().toString().trim() == "") {
            etPswd.error = "Password Required";
            etPswd.requestFocus()
            return false
        }
        if (bool != isValidPassword(etPswd.getText().toString())) {
            etPswd.error = "Password not valid"
            etPswd.requestFocus()
            return false
        }
        return true
    }

}