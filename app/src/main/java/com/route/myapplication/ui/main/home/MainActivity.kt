package com.route.myapplication.ui.main.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.myapplication.R
import com.route.myapplication.databinding.ActivityMainBinding
import com.route.myapplication.ui.main.tabs.quran.QuranFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigationListeners()
        showFragment(QuranFragment())
    }

    private fun setupBottomNavigationListeners() {

        binding.barBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.btn_quran -> {
                    showFragment(QuranFragment())
                    true
                }

                R.id.btn_hadith -> {
                    true
                }

                R.id.btn_sebha -> {
                    true
                }

                else -> false
            }
        }
    }
    private fun showFragment (fragment:Fragment){
        supportFragmentManager.beginTransaction().
        replace(binding.fragmentContainer.id,fragment)
            .commit()
    }

}