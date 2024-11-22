package com.aman.quizappcompose.domain.di

import com.aman.quizappcompose.data.remote.QuizApi
import com.aman.quizappcompose.data.repository.QuizRepositoryImpl
import com.aman.quizappcompose.domain.repository.QuizRepository
import com.aman.quizappcompose.domain.usecases.GetQuizzesUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {

    @Provides
    @Singleton
    fun provideGetQuizzesUseCases(quizRepository: QuizRepository): GetQuizzesUseCases {
        return GetQuizzesUseCases(quizRepository)

    }
}