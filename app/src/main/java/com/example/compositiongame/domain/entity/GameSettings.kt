package com.example.compositiongame.domain.entity

data class GameSettings(
    val winner: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings: GameSettings
)