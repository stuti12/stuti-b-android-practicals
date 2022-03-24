package com.example.myapplication.RecycleViewPractical.ViewPager
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.ONE
import com.example.myapplication.ZERO

class ViewPagerAdapter(viewpager: ViewPagerActivity) : FragmentStateAdapter(viewpager) {
    override fun getItemCount(): Int {
        return ZERO
    }

    override fun createFragment(position: Int): Fragment {
        Log.d("Method:","createFrag")
        return when (position) {
            ZERO -> Recent()
            ONE -> MyFavourites()
            else -> Recent()
        }
    }
}