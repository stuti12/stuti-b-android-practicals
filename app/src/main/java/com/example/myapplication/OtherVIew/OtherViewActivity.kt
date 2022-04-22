package com.example.myapplication.OtherVIew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.com.example.myapplication.OtherVIew.SearchView.SearchViewActivity
import com.example.myapplication.com.example.myapplication.OtherVIew.nestedScrollView.ScrollViewActivity
import com.example.myapplication.com.example.myapplication.OtherVIew.webView.WebViewActivity

import kotlinx.android.synthetic.main.activity_other_view.btn_scrollview
import kotlinx.android.synthetic.main.activity_other_view.btn_search
import kotlinx.android.synthetic.main.activity_other_view.btn_webview

class OtherViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_view)
        sendData()
    }
    private fun sendData() {
        btn_search.setOnClickListener {
            val intent = Intent(this@OtherViewActivity, SearchViewActivity::class.java)
            startActivity(intent)
        }
        btn_webview.setOnClickListener {
            val intent = Intent(this@OtherViewActivity, WebViewActivity::class.java)
            startActivity(intent)
        }
        btn_scrollview.setOnClickListener {
            val intent = Intent(this@OtherViewActivity, ScrollViewActivity::class.java)
            startActivity(intent)
        }
    }

}