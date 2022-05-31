package com.example.shop.presentation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.shop.MainActivity
import com.example.shop.R.layout.activity_splash
import com.example.shop.databinding.ActivitySplashBinding

//TODO: this is not properly integration of SplashScreen
//You can use new SplashScreen API what was introduced with compat in android 12 or
//you can do it in old-fashioned way with theme changing.
//TODO: suppress warnings ONLY IF YOU KNOW what you do and you are absolutely confident that you implemented everything right.
@SuppressLint("CustomSplashScreen")
public class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(activity_splash)

        @Suppress("DEPRECATION")
        Handler().postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}