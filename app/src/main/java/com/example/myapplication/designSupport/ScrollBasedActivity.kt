package com.example.myapplication.designSupport

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityDesignsupportDesignSupportBinding
import com.example.myapplication.databinding.ActivityDesignsupportScrollBasedBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_designsupport_scroll_based.toolbar
import kotlinx.android.synthetic.main.activity_designsupport_scroll_based.toolbar_layout

class ScrollBasedActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityDesignsupportScrollBasedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityDesignsupportScrollBasedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar_layout.title = title
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, getString(R.string.msg_clicked), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}