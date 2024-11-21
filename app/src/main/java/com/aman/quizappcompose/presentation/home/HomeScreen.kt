package com.aman.quizappcompose.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.aman.quizappcompose.presentation.common.AppDropDownMenu
import com.aman.quizappcompose.presentation.common.ButtonBox
import com.aman.quizappcompose.presentation.home.component.HomeHeader
import com.aman.quizappcompose.presentation.nav_graph.Routes
import com.aman.quizappcompose.presentation.utils.Constants
import com.aman.quizappcompose.presentation.utils.Constants.difficulty
import com.aman.quizappcompose.presentation.utils.Dimens.MediumPadding
import com.aman.quizappcompose.presentation.utils.Dimens.MediumSpacerHeight
import com.aman.quizappcompose.presentation.utils.Dimens.SmallSpacerHeight


@Composable
fun HomeScreen(
    state: StateHomeScreen,
    event: (EventHomeScreen) -> Unit,
    navController: NavController
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        HomeHeader()

        Spacer (modifier = Modifier.height(MediumSpacerHeight))
        AppDropDownMenu (
            menuName = "Number of Questions:",
            menuList = Constants.numbersAsString,
            text = state.numberOfQuiz.toString(),
            onDropDownClick = {event(EventHomeScreen.SetNumberOfQuizzes(it.toInt()))}
        )


        Spacer (modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu (
            menuName = "Select Category:",
            menuList = Constants.categories,
            text = state.category,
            onDropDownClick = {event(EventHomeScreen.SetQuizCategory(it))}
        )

        Spacer (modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu (
            menuName = "Select Difficulty:",
            menuList = difficulty ,
            text = state.difficulty,
            onDropDownClick = {event(EventHomeScreen.SetQuizDifficulty(it))}
        )

        Spacer (modifier = Modifier.height(SmallSpacerHeight))
        AppDropDownMenu (
            menuName = "Select Type:",
            menuList = Constants.type,
            text = state.type,
            onDropDownClick = {event(EventHomeScreen.SetQuizType(it))}
        )

        Spacer (modifier = Modifier.height(MediumSpacerHeight))
        ButtonBox(text = "Generate Quiz", padding = MediumPadding){
            navController.navigate(
                route = Routes.QuizScreen.passQuizParams(state.numberOfQuiz,state.category,state.difficulty,state.type)
            )
        }
    }
}