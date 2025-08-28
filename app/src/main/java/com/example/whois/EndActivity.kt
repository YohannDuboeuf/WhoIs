package com.example.whois

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.whois.databinding.ActivityEndBinding

class EndActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEndBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEndBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Récupérer le score depuis l'intent
        val score = intent.getIntExtra("SCORE", 0)
        binding.tvScore.text = "Score: $score/5"

        // Rejouer
        binding.btnReplay.setOnClickListener {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish() // fermer l'écran de fin
        }
    }
}
