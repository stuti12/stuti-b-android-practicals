package com.example.myapplication.layout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_layout.*

class LayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        showLayout()
    }

    private fun showLayout() {
        btn_linear.setOnClickListener {
            val intent = Intent(this@LayoutActivity, FeedbackActivity::class.java)
            startActivity(intent)
        }
        btn_relative.setOnClickListener {
            val intent = Intent(this@LayoutActivity, RelativeActivity::class.java)
            startActivity(intent)
        }
        btn_table.setOnClickListener {
            val intent = Intent(this@LayoutActivity, TableActivity::class.java)
            startActivity(intent)
        }
        btn_grid.setOnClickListener {
            val intent = Intent(this@LayoutActivity, GridActivity::class.java)
            startActivity(intent)
        }
        btn_constraint.setOnClickListener {
            val intent = Intent(this@LayoutActivity, ConstraintActivity::class.java)
            startActivity(intent)
        }
        btn_frame.setOnClickListener {
            val intent = Intent(this@LayoutActivity, FrameActivity::class.java)
            startActivity(intent)
        }
    }
}