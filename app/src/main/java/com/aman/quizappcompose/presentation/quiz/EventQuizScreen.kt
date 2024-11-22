package com.aman.quizappcompose.presentation.quiz

sealed class EventQuizScreen{
    data class GetQuizzes(
        val numOfQuizzes :Int,
        val category :Int,
        val difficulty :String,
        val type :String,
    ):EventQuizScreen()
}

