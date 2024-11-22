package com.aman.quizappcompose.domain.usecases

import com.aman.quizappcompose.common.Resources
import com.aman.quizappcompose.domain.model.Quiz
import com.aman.quizappcompose.domain.repository.QuizRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class GetQuizzesUseCases(
    val quizRepository: QuizRepository
){
        operator fun invoke(
            amount: Int,
            category: Int,
            difficulty: String,
            type: String
        ): Flow<Resources<List<Quiz>>> = flow{
            emit(Resources.Loading())

            try {
                emit(Resources.Success(data = quizRepository.getQuizzes(amount, category, difficulty, type)))
            }
            catch (e:Exception){
                emit(Resources.Error(message = e.message.toString()))
            }


        }.flowOn(Dispatchers.IO)
}