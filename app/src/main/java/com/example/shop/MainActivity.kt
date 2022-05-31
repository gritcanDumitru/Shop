package com.example.shop

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shop.data.NetworkStatusChecker
import com.example.shop.databinding.ActivityMainBinding

@SuppressLint("NewApi")
class MainActivity : AppCompatActivity() {

    //TODO: remove test comments
    //Test comment

    //TODO: MinSDK of this object is 23, the project min is 22. If you want to use is (do not know for that for sure)
    //TODO: you need to set minSDK to 23 or make two different realisations for <23 and 23+ SDKs
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