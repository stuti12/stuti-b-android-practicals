package com.example.myapplication.Fragment

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.ONE
import com.example.myapplication.R
import com.example.myapplication.TWO
import com.example.myapplication.ZERO
import kotlinx.android.synthetic.main.activity_bottom_navigation.bottomNavigationView
import kotlinx.android.synthetic.main.activity_bottom_navigation.viewPager

class BottomNavigationActivity : AppCompatActivity() {
    private var currentMenuItem : MenuItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_bottom_navigation)
        setBottomNavigation()

    }

    private fun setBottomNavigation() {
        val myAdapter = BottomNavigationAdapter(supportFragmentManager, lifecycle)
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

                R.id.home ->viewPager.currentItem = 0
                R.id.person ->viewPager.currentItem = 1
                R.id.search ->viewPager.currentItem=2
            }
            true
        }
    }
   //other way for datapassing
    /* fun passData(ediTextInput: String) {
        val bundle = Bundle()
        bundle.putString("message", ediTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val secondFragment = ViewMessageFragment()
        secondFragment.arguments = bundle
        viewPager.currentItem = 2
        transaction.replace(R.id.frameLayout,secondFragment)
        transaction.commit()
    }*/

}

internal class BottomNavigationAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            ZERO -> GalleryFragment()
            ONE -> SendMessageFragment()
            TWO -> ViewMessageFragment()
            else -> GalleryFragment()
        }
    }

}
