package com.example.whois.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.whois.ui.screens.MainScreen
import com.example.whois.ui.theme.WhoIsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhoIsTheme {
                MainScreen()
            }
        }
    }
}