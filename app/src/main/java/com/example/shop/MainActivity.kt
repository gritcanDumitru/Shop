@file:Suppress("DEPRECATION")

package com.example.shop

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.shop.data.NetworkStatusChecker
import com.example.shop.databinding.ActivityMainBinding
import com.example.shop.presentation.FragmentProductFeed

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

        setupViewPager()


    }

    @Suppress("DEPRECATION")
    private fun setupViewPager() {
        binding.viewPager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

            override fun getItem(position: Int): Fragment {
                return FragmentProductFeed.newInstance()
            }

            override fun getCount(): Int = 1

        }
    }

}