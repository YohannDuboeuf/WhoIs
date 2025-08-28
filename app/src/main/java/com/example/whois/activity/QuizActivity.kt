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
                QuizScreen(viewModel) // Passer le ViewModel à l'écran de quiz
            }
        }
    }
}