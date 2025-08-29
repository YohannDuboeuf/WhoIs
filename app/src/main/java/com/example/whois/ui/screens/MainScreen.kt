package com.example.whois.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import com.example.whois.activity.QuizActivity
import com.example.whois.ui.components.Carousel
import com.example.whois.ui.components.CustomButton
import com.example.whois.R


@Composable
fun MainScreen() {
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
                .padding(50.dp)
                .align(Alignment.Center),
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
}