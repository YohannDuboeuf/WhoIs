package com.example.whois.model

data class Question(
    val imageResId: Int,
    val options: List<String>,
    val correctAnswerIndex: Int
)