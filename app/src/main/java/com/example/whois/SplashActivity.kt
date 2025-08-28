package com.example.whois

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val animationView: LottieAnimationView = findViewById(R.id.animationView)

        // Start the animation
        animationView.playAnimation()

        // Set up a listener for when the animation is finished
        animationView.addAnimatorListener(object : AnimatorListenerAdapter() {
            var playCount = 0

            // This is called when the animation ends
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                playCount++
                if (playCount < 1) {
                    // Replay the animation once more
                    animationView.playAnimation()
                } else {
                    // After two plays, navigate to the MainActivity
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                    finish() // Finish SplashActivity to prevent the user from going back
                }
            }
        })

        // Ensure animation stops looping after two plays
        animationView.repeatCount = 0 // To ensure it does not loop indefinitely
    }
}
