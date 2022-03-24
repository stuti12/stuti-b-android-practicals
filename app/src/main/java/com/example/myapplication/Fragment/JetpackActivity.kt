package com.example.myapplication.Fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.example.myapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class JetpackActivity : AppCompatActivity() {
    lateinit var navC : NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack)

       showJetpack()
    }
    private fun showJetpack() {
        val bottomNavigationView2 : BottomNavigationView = findViewById(R.id.bottomNavigationView2)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        setupWithNavController(bottomNavigationView2, navController)
    }

}
