package com.example.pleasureinvegas

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(mainLooper).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, IntroSliderActivity::class.java))
            finish()
        }, 3000)
    }
}