package com.aman.quizappcompose.data.remote

import com.aman.quizappcompose.data.remote.dto.QuizResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuizApi {

    @GET
    suspend fun getQuizzes(
        @Query("amount") amount:Int,
        @Query("category") category:Int,
        @Query("difficulty") difficulty:String,
        @Query("type") type:String
    ):QuizResponse
}