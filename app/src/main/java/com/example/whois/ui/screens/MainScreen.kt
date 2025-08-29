package com.example.whois.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.whois.activity.QuizActivity
import com.example.whois.ui.components.Carousel
import com.example.whois.ui.components.CustomButton

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenue dans Who Is ?", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Carousel(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        CustomButton(text = "Commencer le quiz") {
            context.startActivity(Intent(context, QuizActivity::class.java))
        }
    }
}
