package com.aman.quizappcompose.presentation.quiz

import com.aman.quizappcompose.domain.model.Quiz

data class StateQuizScreen(
    val isLoading : Boolean = false,
    val data : List<Quiz> ?= emptyList(),
    val error : String = ""
)