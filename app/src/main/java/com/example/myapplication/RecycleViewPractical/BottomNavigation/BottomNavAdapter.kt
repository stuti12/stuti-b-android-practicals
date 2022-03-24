package com.example.myapplication.RecycleViewPractical.BottomNavigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ONE
import com.example.myapplication.THREE
import com.example.myapplication.TWO
import com.example.myapplication.ZERO

class BottomNavAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return THREE
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            ZERO -> HomeFragment()
            ONE -> PersonFragment()
            TWO -> SearchFragment()
            else -> HomeFragment()
        }
    }
}
