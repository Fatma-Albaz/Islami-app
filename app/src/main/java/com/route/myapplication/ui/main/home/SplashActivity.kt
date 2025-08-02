package com.route.myapplication.ui.main.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.route.myapplication.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}