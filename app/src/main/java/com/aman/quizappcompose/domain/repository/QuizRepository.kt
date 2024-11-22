package com.aman.quizappcompose.domain.repository

import com.aman.quizappcompose.data.remote.dto.QuizResponse
import com.aman.quizappcompose.domain.model.Quiz

interface QuizRepository {
    suspend fun getQuizzes(amount:Int, category:Int, difficulty:String, type:String): List<Quiz>

}