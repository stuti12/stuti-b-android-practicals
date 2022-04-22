package com.example.myapplication.designSupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDesignsupportLayoutBasedBinding
import com.google.android.material.snackbar.Snackbar

class LayoutBasedActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDesignsupportLayoutBasedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityDesignsupportLayoutBasedBinding.inflate(layoutInflater)
        setContentView(binding.root)
      //  setSupportActionBar(binding.toolbar)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.msg_clicked), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}
