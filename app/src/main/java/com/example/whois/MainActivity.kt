package com.example.whois

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Trouver le bouton pour démarrer le quiz
        val startButton: Button = findViewById(R.id.startButton)

        // Ajouter un listener pour lancer QuizActivity
        startButton.setOnClickListener {
            // Lancer QuizActivity
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish() // Empêche de revenir à MainActivity
        }
    }
}
