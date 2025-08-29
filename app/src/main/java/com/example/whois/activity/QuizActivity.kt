package com.example.whois.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.whois.ui.screens.QuizScreen
import com.example.whois.ui.theme.WhoIsTheme
import com.example.whois.viewmodel.QuizViewModel

class QuizActivity : ComponentActivity() {
    private val viewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhoIsTheme {
                // Passe la fonction onRestartQuiz à QuizScreen
                QuizScreen(viewModel) {
                    // Appelle resetQuiz dans le ViewModel pour réinitialiser le quiz
                    viewModel.resetQuiz()
                    // Redémarre l'UI avec l'état réinitialisé
                    setContent {
                        WhoIsTheme {
                            QuizScreen(viewModel) { }
                        }
                    }
                }
            }
        }
    }
}
