package com.example.whois.ui.screens

import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whois.activity.QuizActivity

@Composable
fun EndScreen(score: Int) {
    val context = LocalContext.current

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
            context.startActivity(Intent(context, QuizActivity::class.java))
        }) {
            Text(text = "Rejouer")
        }
    }
}
