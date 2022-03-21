package com.example.myapplication.RecycleViewPractical.ViewPager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)
         setUpViewPager(viewPager)
    }

    private fun setUpViewPager(viewPager: ViewPager2) {
        val titles = arrayListOf("Recent", "Favourite")
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tablayout, viewPager) { myTabLayout: TabLayout.Tab, position: Int ->
            myTabLayout.text = titles[position]
        }.attach()
    }
}