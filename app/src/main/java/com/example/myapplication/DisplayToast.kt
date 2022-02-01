package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar

class DisplayToast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_toast)
        val btnToast : Button = findViewById(R.id.btntoast)
        val btnToastCustom: Button = findViewById(R.id.btntoast2)
        val linearLayout: LinearLayout = findViewById(R.id.linearToast)
        val btnToastMaterial : Button = findViewById(R.id.btntoast3)
        val btnMaterial: Button = findViewById(R.id.btnMaterial)
        btnToast.setOnClickListener {
            Toast.makeText(this@DisplayToast, "Toast", Toast.LENGTH_LONG).show();

        }
        btnToastCustom.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                Toast(this@DisplayToast).showCustomToast(
                    "Hello! This is a custom Toast!",
                    this@DisplayToast
                )
            }
        })
        btnToastMaterial.setOnClickListener {
            Snackbar.make(
                linearLayout, "Snackbar- showing a Toast Message",
                Snackbar.LENGTH_LONG
            ).setAction(
                "Show Now"
            ) {
                Toast.makeText(
                    applicationContext,
                    "An Action Showing!",
                    Toast.LENGTH_SHORT
                ).show()
                linearLayout
            }.show()
        }
        btnMaterial.setOnClickListener {
            val intent = Intent(this@DisplayToast, MaterialActivity::class.java)
            startActivity(intent)
        }
    }
}
