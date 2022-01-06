package com.example.pleasureinvegas.view.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.pleasureinvegas.R
import com.example.pleasureinvegas.databinding.LoginLayoutBinding
import com.example.pleasureinvegas.view.main.MainActivity
import com.example.pleasureinvegas.view.register.SignUpActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: LoginLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.login_layout)
        init()
    }

    private fun init() {
        binding.tvSignup.setOnClickListener {
            startActivity(Intent(this@LoginActivity,
                SignUpActivity::class.java))
        }
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }
}