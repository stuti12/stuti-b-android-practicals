package com.example.myapplication.RecycleViewPractical.BottomNavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_bottom_nav.*

class BottomNavActivity : AppCompatActivity() {
    private var currentMenuItem : MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav)

        bottomNavigation()
    }


    private fun bottomNavigation() {
        val myAdapter = BottomNavAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = myAdapter
        viewPager.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentMenuItem?.isChecked = false
                bottomNavigationView.menu.getItem(position).isChecked = true
                currentMenuItem = bottomNavigationView.menu.getItem(position)
            }
        })
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home ->viewPager.currentItem=0
                R.id.person ->viewPager.currentItem=1
                R.id.search ->viewPager.currentItem=2
            }
            true
        }
    }
}