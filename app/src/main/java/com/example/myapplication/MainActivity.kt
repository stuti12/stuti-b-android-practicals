package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Fragment.FragmentActivity
import com.example.myapplication.RecycleViewPractical.RecycleActivity
import com.example.myapplication.UI_Widgets.DisplayMessageActivity
import com.example.myapplication.designSupport.DesignSupportActivity
import com.example.myapplication.layout.LayoutActivity
import kotlinx.android.synthetic.main.activity_main.btnDesignSupport
import kotlinx.android.synthetic.main.activity_main.btnFeedback
import kotlinx.android.synthetic.main.activity_main.btnForm
import kotlinx.android.synthetic.main.activity_main.btnFragment
import kotlinx.android.synthetic.main.activity_main.btnRecycle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showFragment()


       intentView()
    }
    private fun intentView() {
        btnForm.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            startActivity(intent)
        }
        btnFeedback.setOnClickListener {
            val intent = Intent(this@MainActivity, LayoutActivity::class.java)
            startActivity(intent)
        }
        btnRecycle.setOnClickListener {
            val intent = Intent(this@MainActivity, RecycleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showFragment() {
      btnFragment.setOnClickListener {
           val intent = Intent(this@MainActivity, FragmentActivity::class.java)
            startActivity(intent)
        }
        btnDesignSupport.setOnClickListener {
            val intent = Intent(this@MainActivity, DesignSupportActivity::class.java)
            startActivity(intent)
        }
    }

}