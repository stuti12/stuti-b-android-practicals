package com.example.myapplication.RecycleViewPractical

import com.example.myapplication.RecycleViewPractical.BottomNavigation.BottomNavActivity
import com.example.myapplication.RecycleViewPractical.ItemDecoration.ItemDecorGridActivity
import com.example.myapplication.RecycleViewPractical.ListView.ListViewActivity
import com.example.myapplication.RecycleViewPractical.RecycleView.RecycleViewActivity
import com.example.myapplication.RecycleViewPractical.ViewPager.ViewPagerActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)
        move()
    }
    private fun move() {
        btn_listview.setOnClickListener {
            val intent = Intent(this@RecycleActivity, ListViewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview.setOnClickListener {
            val intent = Intent(this@RecycleActivity, RecycleViewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclegrid.setOnClickListener {
            val intent = Intent(this@RecycleActivity, ItemDecorGridActivity::class.java)
            startActivity(intent)
        }
        btn_recycle_tab.setOnClickListener {
            val intent = Intent(this@RecycleActivity, ViewPagerActivity::class.java)
            startActivity(intent)
        }
        btn_bottom_nav.setOnClickListener {
            val intent = Intent(this@RecycleActivity, BottomNavActivity::class.java)
            startActivity(intent)
        }
    }
}