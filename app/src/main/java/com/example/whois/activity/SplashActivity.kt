package com.example.whois.activity

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.example.whois.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animationView: LottieAnimationView = findViewById(R.id.animationView)

        animationView.playAnimation()

        animationView.addAnimatorListener(object : AnimatorListenerAdapter() {
            var playCount = 0

            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                playCount++
                if (playCount < 1) {
                    animationView.playAnimation()
                } else {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish()
                }
            }
        })

        animationView.repeatCount = 0
    }
}