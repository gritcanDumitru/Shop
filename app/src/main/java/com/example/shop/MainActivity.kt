package com.example.shop

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shop.data.NetworkStatusChecker
import com.example.shop.databinding.ActivityMainBinding

@SuppressLint("NewApi")
class MainActivity : AppCompatActivity() {

    private val networkStatusChecker by lazy {
        NetworkStatusChecker(getSystemService(ConnectivityManager::class.java))
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}