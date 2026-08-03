package com.example.quizpulse_navigation.data

data class Question(
    val text: String,
    val answers: List<String>,
    val correct: Int
)
