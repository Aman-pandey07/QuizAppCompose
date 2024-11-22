package com.aman.quizappcompose.presentation.quiz

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aman.quizappcompose.common.Resources
import com.aman.quizappcompose.domain.usecases.GetQuizzesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuizViewModel @Inject constructor(private val getQuizzesUseCases: GetQuizzesUseCases):ViewModel() {

    private val _quizList = MutableStateFlow(StateQuizScreen())
    val quizList = _quizList


    fun onEvent(event : EventQuizScreen){
        when(event){
            is EventQuizScreen.GetQuizzes ->{
                getQuizzes(event.numOfQuizzes, event.category, event.difficulty, event.type)
            }
        }
    }


    private fun getQuizzes(amount: Int, category: Int, difficulty: String, type: String){
        viewModelScope.launch {
            getQuizzesUseCases(amount, category, difficulty, type).collect { resource ->
                when (resource) {
                    is Resources.Loading -> {
                        _quizList.value = StateQuizScreen(isLoading = true)
                    }

                    is Resources.Success -> {
                        for (quiz in resource.data!!){
                            Log.e("quiz",quiz.toString())
                        }
                        _quizList.value = StateQuizScreen(data = resource.data)
                    }
                    is Resources.Error ->{
                        _quizList.value = StateQuizScreen(error =  resource.message.toString())
                    }
                    else -> {}
                }
            }
        }

    }

}