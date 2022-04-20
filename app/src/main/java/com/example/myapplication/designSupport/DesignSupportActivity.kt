package com.example.myapplication.designSupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDesignsupportDesignSupportBinding

class DesignSupportActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDesignsupportDesignSupportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignsupportDesignSupportBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}