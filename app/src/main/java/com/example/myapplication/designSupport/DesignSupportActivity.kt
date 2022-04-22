package com.example.myapplication.designSupport

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDesignsupportDesignSupportBinding

class DesignSupportActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDesignsupportDesignSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignsupportDesignSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setListener()
    }
    private  fun setListener() {
        binding.btnDesignBased.setOnClickListener {
            val intent = Intent(this@DesignSupportActivity, LayoutBasedActivity::class.java)
            startActivity(intent)
        }
        binding.btnScrollBased.setOnClickListener {
            val intent = Intent(this@DesignSupportActivity, ScrollBasedActivity::class.java)
            startActivity(intent)
        }
    }
}