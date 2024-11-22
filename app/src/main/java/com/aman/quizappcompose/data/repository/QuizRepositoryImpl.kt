package com.aman.quizappcompose.data.repository

import com.aman.quizappcompose.data.remote.QuizApi
import com.aman.quizappcompose.domain.model.Quiz
import com.aman.quizappcompose.domain.repository.QuizRepository

class QuizRepositoryImpl(
    private val quizApi: QuizApi
):QuizRepository {
    override suspend fun getQuizzes(
        amount: Int,
        category: Int,
        difficulty: String,
        type: String
    ): List<Quiz> {
        return quizApi.getQuizzes(amount, category, difficulty, type).results
    }
}