package com.example.myapplication

import com.example.myapplication.OtherVIew.OtherViewActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.Layouts.LayoutActivity
import com.example.myapplication.RecycleViewPractical.RecycleActivity
import com.example.myapplication.UI_Widgets.DisplayMessageActivity
import kotlinx.android.synthetic.main.activity_main.btnFeedback
import kotlinx.android.synthetic.main.activity_main.btnForm
import kotlinx.android.synthetic.main.activity_main.btnFragment
import kotlinx.android.synthetic.main.activity_main.btnOtherView
import kotlinx.android.synthetic.main.activity_main.btnRecycle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun setData() {
        btnForm.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            startActivity(intent)
        }
        btnFeedback.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                com.example.myapplication.layout.LayoutActivity::class.java
            )
            startActivity(intent)
        }
        btnRecycle.setOnClickListener {
            val intent = Intent(this@MainActivity, RecycleActivity::class.java)
            startActivity(intent)
        }

        btnFragment.setOnClickListener {
            val intent = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intent)
        }

        btnOtherView.setOnClickListener {
            val intent = Intent(this@MainActivity, OtherViewActivity::class.java)
            startActivity(intent)
        }
    }
}