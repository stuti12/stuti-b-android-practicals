package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentActivity
import com.example.myapplication.OtherVIew.OtherViewActivity
import com.example.myapplication.RecycleViewPractical.RecycleActivity
import com.example.myapplication.UI_Widgets.DisplayMessageActivity
import com.example.myapplication.architecture.ArchitectureActivity
import com.example.myapplication.layout.LayoutActivity
import com.example.myapplication.permission.PermissionActivity
import com.example.myapplication.webService.WebServiceActivity
import kotlinx.android.synthetic.main.activity_main.btnArchitecture
import kotlinx.android.synthetic.main.activity_main.btnFeedback
import kotlinx.android.synthetic.main.activity_main.btnForm
import kotlinx.android.synthetic.main.activity_main.btnFragment
import kotlinx.android.synthetic.main.activity_main.btnPermission
import kotlinx.android.synthetic.main.activity_main.btnOtherView
import kotlinx.android.synthetic.main.activity_main.btnRecycle
import kotlinx.android.synthetic.main.activity_main.btnWebService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setData()
    }

    private fun setData() {
        setListener()
    }
   private fun setListener() {
        val btnForm : Button = findViewById(R.id.btnForm)
        btnForm.setOnClickListener {
            val intent = Intent(this@MainActivity, DisplayMessageActivity::class.java)
            startActivity(intent)
        }
        btnFeedback.setOnClickListener {
            val intent = Intent(
                this@MainActivity,LayoutActivity::class.java)
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
        btnPermission.setOnClickListener {
            val intent = Intent(this@MainActivity, PermissionActivity::class.java)
            startActivity(intent)
        }

        btnOtherView.setOnClickListener {
            val intent = Intent(this@MainActivity, OtherViewActivity::class.java)
            startActivity(intent)
        }

        btnWebService.setOnClickListener {
            val intent = Intent(this@MainActivity, WebServiceActivity::class.java)
            startActivity(intent)
        }
       btnArchitecture.setOnClickListener {
           val intent = Intent(this@MainActivity, ArchitectureActivity::class.java)
           startActivity(intent)
       }
    }

}