package com.example.pleasureinvegas.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.view.intro.view.IntroSliderActivity

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