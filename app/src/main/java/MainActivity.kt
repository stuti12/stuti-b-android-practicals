package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.Layouts.LayoutActivity
import com.example.myapplication.UI_Widgets.DisplayMessageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnForm : Button = findViewById(R.id.btnForm)
        btnForm.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            startActivity(intent)
        }
        val btnFeedback : Button = findViewById(R.id.btnFeedback)

        btnFeedback.setOnClickListener {
            val intent = Intent(this@MainActivity, LayoutActivity::class.java)
            startActivity(intent)
        }
    }
}