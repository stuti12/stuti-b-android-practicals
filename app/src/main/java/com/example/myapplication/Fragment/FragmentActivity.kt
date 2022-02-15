package com.example.myapplication.Fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_fragment.btnFragmentFragmentcontainer
import kotlinx.android.synthetic.main.activity_fragment.btnFragmentJetpack
import kotlinx.android.synthetic.main.activity_fragment.btnFragmentSimple

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        showFragment()
    }
    private fun showFragment() {
        btnFragmentSimple.setOnClickListener {
            val intent = Intent(this@FragmentActivity, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        btnFragmentFragmentcontainer.setOnClickListener {
            val intent = Intent(this@FragmentActivity, FragmentContainActivity::class.java)
            startActivity(intent)
        }
        btnFragmentJetpack.setOnClickListener {
            val intent = Intent(this@FragmentActivity, JetpackActivity::class.java)
            startActivity(intent)
        }
    }
}