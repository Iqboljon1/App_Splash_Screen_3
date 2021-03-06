package com.ir.appsplashscreen3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ir.appsplashscreen3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        supportActionBar!!.hide()
        setContentView(binding.root)
    }
}