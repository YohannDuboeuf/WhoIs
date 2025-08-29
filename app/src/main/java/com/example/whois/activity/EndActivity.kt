package com.example.whois.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.whois.ui.screens.EndScreen
import com.example.whois.ui.theme.WhoIsTheme

class EndActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhoIsTheme {
                EndScreen(
                    score = intent.getIntExtra("SCORE", 0),
                    onRestartQuiz = {
                        val intent = Intent(this, QuizActivity::class.java)
                        startActivity(intent) // Redémarre l'activité du quiz
                        finish()
                    }
                )
            }
        }
    }
}
