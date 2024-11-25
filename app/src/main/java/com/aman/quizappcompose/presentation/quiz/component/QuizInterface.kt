package com.aman.quizappcompose.presentation.quiz.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.AnimationConstants.DefaultDurationMillis
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.aman.quizappcompose.R
import com.aman.quizappcompose.presentation.utils.Dimens
import com.aman.quizappcompose.presentation.utils.Dimens.MediumBoxHeight

@Composable
fun QuizInterface(
    onOptionSelected:(Int)-> Unit,
    qNumber:Int,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier.wrapContentHeight()
        ){
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    modifier = Modifier.weight(1f),
                    text = "$qNumber.",
                    color = colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.SmallTextSize
                )
                Text(
                    modifier = Modifier.weight(9f),
                    text = "Question",
                    color = colorResource(id = R.color.blue_grey),
                    fontSize = Dimens.SmallTextSize
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 15.dp)
            ){
                val options = listOf(
                    "A" to "Doraemon",
                    "B" to "Oggy",
                    "C" to "Ben 10",
                    "D" to "Tom and Jerry",
                )
                Column {
                    options.forEachIndexed{index,(optionNumber,optionText)->
                        if(optionText.isNotEmpty()){
                            QuizOption(
                                optionNumber = optionNumber,
                                option = optionText,
                                selected = false,
                                onOptionClicked = { onOptionSelected(index)},
                                onUnselectOption = { onOptionSelected(-1) }
                            )
                        }
                        Spacer(modifier = Modifier.height(Dimens.SmallSpacerHeight))
                    }
                }
                Spacer(modifier = Modifier.height(Dimens.ExtraLargeSpacerHeight))
            }
        }
    }
}

@Composable
fun QuizOption(
    optionNumber : String,
    option :String,
    selected : Boolean,
    onOptionClicked :()-> Unit,
    onUnselectOption :() -> Unit,
){
    val optionTextColor = if(selected) colorResource(id = R.color.blue_grey) else colorResource(id = R.color.black)
    val transition = updateTransition(selected, label = "selected")

    val startColor by transition.animateColor(
        transitionSpec = { tween(durationMillis = DefaultDurationMillis, easing = LinearEasing) },
        label = "startColor"
    ){selectedBox->
        if(selectedBox) colorResource(id = R.color.orange)
        else colorResource(id = R.color.blue_grey)
    }

    Box(
        modifier = Modifier
            .noRippleClickable{ onOptionClicked()}
            .fillMaxWidth()
            .height(MediumBoxHeight)
            .clip(RoundedCornerShape(Dimens.LargeCornerRadius))
    )

}
