package com.example.myapplication.UI_Widgets

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.*
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import java.util.regex.Pattern

class DisplayMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
        show()
        showButton()
        showText()
    }

    private fun showText() {
        val bool: Boolean = true
        val etEmail: EditText = findViewById(R.id.login_email)
        val etPassword: EditText = findViewById(R.id.login_password)
        etEmail.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val etEmail: EditText = findViewById(R.id.login_email)
                if (!etEmail.text.toString().isEmailValid()) {
                    etEmail.error = "Email not valid"
                    etEmail.requestFocus()
                }
            }
        })
        etPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (etPassword.text.length < 8) {
                    etPassword.error = "Password length short"
                } else if (bool != isValidPassword(etPassword.text.toString())) {
                    etPassword.error =
                        "Atleast 8 characters and 1 uppercase, 1 number, 1 Special symbol"
                    etPassword.requestFocus()
                    // boolSuccess = false
                }
            }
        })
    }

    private fun showButton() {
        val btnLogin: Button = findViewById(R.id.login_button)
        val btnBack: Button = findViewById(R.id.back_button)
        val btnToast: Button = findViewById(R.id.btn_toast)
        val showBtn: ToggleButton = findViewById(R.id.show_pass_btn)
        fun validationSuccess(): Boolean {
            val etName: EditText = findViewById(R.id.login_name)
            val etEmail: EditText = findViewById(R.id.login_email)
            val etPassword: EditText = findViewById(R.id.login_password)

            var boolSuccess: Boolean = true
            when {
                etName.text.toString().trim() == "" -> {
                    etName.error = "Username Required"
                    etName.requestFocus()
                    boolSuccess = false
                }
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

        showBtn.setOnCheckedChangeListener { _, isChecked ->
            val etPassword: EditText = findViewById(R.id.login_password)
            if (isChecked) {
                etPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                Toast.makeText(this, "Toggle on", Toast.LENGTH_SHORT).show()
            } else {
                etPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                Toast.makeText(this, "Toggle off", Toast.LENGTH_SHORT).show()
            }
        }
        btnLogin.setOnClickListener {
            if (validationSuccess()) {
                Toast.makeText(this@DisplayMessageActivity, "Login", Toast.LENGTH_LONG).show();
            }
        }
        btnBack.setOnClickListener {
            val intent = Intent(this@DisplayMessageActivity, MainActivity::class.java)
            startActivity(intent)
        }
        btnToast.setOnClickListener {
            val intent = Intent(this@DisplayMessageActivity, DisplayToast::class.java)
            startActivity(intent)
        }

    }

    private fun show() {
        val checkBox: CheckBox = findViewById(R.id.chk_gender)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            val etName: EditText = findViewById(R.id.login_name)
            val etEmail: EditText = findViewById(R.id.login_email)
            val name: String = etName.text.toString()
            val email: String = etEmail.text.toString()
            Toast.makeText(this, name + "" + email, Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show()
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rbmale ->
                    if (checked) {
                        Toast.makeText(this@DisplayMessageActivity, "Male", Toast.LENGTH_LONG)
                            .show();
                    }
                R.id.rbfemale ->
                    if (checked) {
                        Toast.makeText(this@DisplayMessageActivity, "Female", Toast.LENGTH_LONG)
                            .show();
                    }
            }
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

    fun String.isEmailValid() =
        Pattern.compile(
            "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                    "\\@" + "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                    "(" + "\\." +
                    "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" + ")+"
        ).matcher(this).matches()


}

