package com.example.whois.model

data class Question(
    val imageResId: Int, // Id de l'image
    val options: List<String>, // Réponses possible
    val correctAnswerIndex: Int // Réponse attendu
)