package com.example.myapplication.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_fragment_contain.btn_gallery_fragment
import kotlinx.android.synthetic.main.activity_fragment_contain.btn_send_fragment
import kotlinx.android.synthetic.main.activity_fragment_contain.btn_view_fragment

class FragmentContainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_contain)
        showFragment()
    }

    private fun showFragment() {
        btn_gallery_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, GalleryFragment::class.java, null)
                addToBackStack(null)
            }
        }
        btn_send_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, SendMessageFragment::class.java, null)
                addToBackStack(null)
            }
        }
        btn_view_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host, ViewMessageFragment::class.java, null)
                addToBackStack(null)
            }
        }
    }


}