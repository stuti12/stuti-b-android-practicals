package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.Layouts.LayoutActivity
import com.example.myapplication.UI_Widgets.DisplayMessageActivity
import com.example.myapplication.webService.WebServiceActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListener()
    }
   private fun setListener() {
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
        val btnWebService : Button = findViewById(R.id.btnWebService)

        btnWebService.setOnClickListener {
            val intent = Intent(this@MainActivity, WebServiceActivity::class.java)
            startActivity(intent)
        }
    }

}