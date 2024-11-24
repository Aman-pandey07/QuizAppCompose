package com.aman.quizappcompose.presentation.quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import com.aman.quizappcompose.R
import com.aman.quizappcompose.presentation.common.QuizAppBar
import com.aman.quizappcompose.presentation.utils.Constants
import com.aman.quizappcompose.presentation.utils.Dimens
import com.aman.quizappcompose.presentation.utils.Dimens.LargeSpacerHeight
import com.aman.quizappcompose.presentation.utils.Dimens.MediumCornerRadius
import com.aman.quizappcompose.presentation.utils.Dimens.SmallSpacerHeight
import com.aman.quizappcompose.presentation.utils.Dimens.VerySmallPadding


@Composable
fun QuizScreen(
    numOfQuiz: Int,
    quizCategory: String,
    quizDifficulty: String,
    quizType: String,
    event: (EventQuizScreen) -> Unit,
    state: StateQuizScreen
) {

    LaunchedEffect(key1 = Unit){

        val difficulty = when(quizDifficulty){
             "Medium" -> "medium"
             "Hard" -> "hard"
            else -> "easy"
        }
        val type = when(quizType){
            "Multiple Choice" -> "multiple"
            else -> "boolean"
        }
        event(EventQuizScreen.GetQuizzes(numOfQuiz,Constants.categoriesMap[quizCategory]!!,difficulty,type))
    }
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        
        QuizAppBar(quizCategory = quizCategory) {
            
        }
        
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(Dimens.SmallPadding)

        ){
            Spacer(modifier = Modifier.height(LargeSpacerHeight))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Questions: $numOfQuiz",
                    color=colorResource(id = R.color.blue_grey)
                )
                Text(
                    text = quizDifficulty,
                    color=colorResource (id = R.color.blue_grey)
                )
            }
            Spacer(modifier = Modifier.height(SmallSpacerHeight))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(Dimens.SmallSpacerHeight)
                    .clip(RoundedCornerShape(MediumCornerRadius))
                    .background(
                        color = colorResource(id = R.color.blue_grey)
                    ),
            )

            Spacer(modifier = Modifier.height(LargeSpacerHeight))

        }
    }
}