package com.aman.quizappcompose.data.remote.dto

import com.aman.quizappcompose.domain.model.Quiz

data class QuizResponse(
    val response_code: Int,
    val results: List<Quiz>
)