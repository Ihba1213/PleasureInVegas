package com.example.pleasureinvegas

import android.app.ActionBar
import android.app.Dialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.pleasureinvegas.adapter.IntroSliderAdapter
import com.example.pleasureinvegas.databinding.ActivityIntroSliderBinding
import com.example.pleasureinvegas.fragment.Intro1Fragment
import com.example.pleasureinvegas.fragment.Intro2Fragment
import com.example.pleasureinvegas.fragment.Intro3Fragment

class IntroSliderActivity : AppCompatActivity() {
    lateinit var binding: ActivityIntroSliderBinding
    private val fragmentList = ArrayList<Fragment>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intro_slider)
        initview();

    }

    private fun initview() {
        val adapter = IntroSliderAdapter(this)
        binding.vpIntroSlider.adapter = adapter
        fragmentList.addAll(
            listOf(
                Intro1Fragment(), Intro2Fragment(), Intro3Fragment()
            )
        )
        adapter.setFragmentList(fragmentList)
        binding.indicatorLayout.setIndicatorCount(adapter.itemCount)
        binding.indicatorLayout.selectCurrentPosition(0)
        registerListeners()
    }

    private fun registerListeners() {
        binding.vpIntroSlider.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.indicatorLayout.selectCurrentPosition(position)
                if (position < fragmentList.lastIndex) {
                    binding.tvSkip.visibility = View.VISIBLE
                    binding.tvNext.text = "Next"
                } else {
                    binding.tvSkip.visibility = View.GONE
                    binding.tvNext.text = "Get Started"
                }
            }
        })
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        binding.tvNext.setOnClickListener {
            val position = binding.vpIntroSlider.currentItem
            if (position < fragmentList.lastIndex) {
                binding.vpIntroSlider.currentItem = position + 1
            } else {
                openLoginConfirmationAlert();
            }
        }
    }
    private fun openLoginConfirmationAlert() {
        val dialog = Dialog(this,R.style.Theme_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.login_confirmation)
        val user = dialog.findViewById(R.id.user_selected) as TextView
        val cancel = dialog.findViewById(R.id.cancel) as ImageView
        val agent = dialog.findViewById(R.id.agent_selected) as TextView
        cancel.setOnClickListener {
            dialog.dismiss()
        }
        user.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java).putExtra("type", "user"))
        }
        agent.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java).putExtra("type", "agent"))
        }
        dialog.show()

    }
}