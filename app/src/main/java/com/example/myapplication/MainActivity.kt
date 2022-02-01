package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnForm : Button = findViewById(R.id.btnForm)
        val btnFeedback : Button = findViewById(R.id.btnFeedback)
        btnForm.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            startActivity(intent)
        }
        /*btnFeedback.setOnClickListener {
            val intent = Intent(this@MainActivity, LayoutActivity::class.java)
            startActivity(intent)
        }*/
    }
}