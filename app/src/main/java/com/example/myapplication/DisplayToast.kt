package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_display_toast.btnMaterial
import kotlinx.android.synthetic.main.activity_display_toast.btnToast
import kotlinx.android.synthetic.main.activity_display_toast.btnToastCustom
import kotlinx.android.synthetic.main.activity_display_toast.btnToastMaterial
import kotlinx.android.synthetic.main.activity_display_toast.linearToast

class DisplayToast : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_toast)
       showData()
    }

    private fun showData() {
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
                linearToast, "Snackbar- showing a Toast Message",
                Snackbar.LENGTH_LONG
            ).setAction(
                "Show Now"
            ) {
                Toast.makeText(
                    applicationContext,
                    "An Action Showing!",
                    Toast.LENGTH_SHORT
                ).show()
                linearToast
            }.show()
        }
        btnMaterial.setOnClickListener {
            val intent = Intent(this@DisplayToast, MaterialActivity::class.java)
            startActivity(intent)
        }
    }
}
