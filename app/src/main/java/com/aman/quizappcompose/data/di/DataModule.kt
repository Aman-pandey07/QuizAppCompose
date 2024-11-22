package com.aman.quizappcompose.data.di

import com.aman.quizappcompose.data.remote.QuizApi
import com.aman.quizappcompose.data.repository.QuizRepositoryImpl
import com.aman.quizappcompose.domain.repository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApi {
        return Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuizApi::class.java)
    }

    @Provides
    @Singleton
    fun provideQuizRepository(quizApi: QuizApi): QuizRepository {
        return QuizRepositoryImpl(quizApi)
    }

}