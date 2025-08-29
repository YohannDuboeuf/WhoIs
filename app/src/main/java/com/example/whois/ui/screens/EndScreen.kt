package com.example.whois.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whois.R
import com.example.whois.activity.QuizActivity

@Composable
fun EndScreen(score: Int, onRestartQuiz: () -> Unit) {
    val context = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.whois_custom_logo),
            contentDescription = "Test Image",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(top = 32.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Score: $score/5", fontSize = 28.sp)
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = {
                onRestartQuiz() // reload le Quiz
            }) {
                Text(text = "Rejouer")
            }
        }
    }
}
