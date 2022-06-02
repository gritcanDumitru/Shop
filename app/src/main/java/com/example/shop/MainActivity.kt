package com.example.shop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.shop.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //TODO: remove test value a
    val a = BigDecimal(10)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*binding.toolbar.apply {
            toolbarBack.isVisible = false

            toolbarFavorite.setOnClickListener {
                toolbarUser.isVisible = false
                toolbarBack.isVisible = true
                toolbarFavorite.isActivated = true
            }

            toolbarBack.setOnClickListener {
                toolbarUser.isVisible = true
                toolbarBack.isVisible = false
                toolbarFavorite.isActivated = false

            }
        }*/

    }
}