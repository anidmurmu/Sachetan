package com.example.sachetan.ui.problem_desc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sachetan.R
import com.example.sachetan.ui.base_compose.units.BaseDpValues
import com.example.sachetan.ui.base_compose.units.BasePadding

@Composable
fun ProblemDescriptionScreen(viewModel: ProblemDescriptionViewModel,
    onSubmit: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = BasePadding.Default),
    ) {
        Text(text = "What's on you mind?",
            color = Color.Black,
            fontSize = 32.sp,
            fontFamily = FontFamily.SansSerif,
        modifier = Modifier
            .padding(top = 48.dp)
            .wrapContentWidth()
            .align(alignment = Alignment.CenterHorizontally))
        Text(text = "I want to..",
            color = colorResource(id = R.color.problem_sub_title_color),
            modifier = Modifier
                .padding(top = 16.dp)
                .wrapContentWidth()
                .align(alignment = Alignment.CenterHorizontally))
        ProblemDescriptionItem(stringResource(id = R.string.burnt_out_msg), viewModel, ProblemViewState.BURNT_OUT_ID,  Modifier)
        ProblemDescriptionItem(stringResource(id = R.string.stressed_msg), viewModel, ProblemViewState.STRESSED_ID, Modifier)
        ProblemDescriptionItem(stringResource(id = R.string.anxiety_msg), viewModel, ProblemViewState.ANXIETY_ID,  Modifier)
        ProblemDescriptionItem(stringResource(id = R.string.calm_msg), viewModel, ProblemViewState.CALM_ID,  Modifier)
        ProblemDescriptionItem(stringResource(id = R.string.something_msg), viewModel, ProblemViewState.SOMETHING_ID,  Modifier)
        Button(onClick = { onSubmit.invoke() },
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.problem_btn_color)),
            modifier = Modifier
                .padding(top = 32.dp)
                .fillMaxWidth()
                .height(BaseDpValues.ItemMinHeight),
            shape = RoundedCornerShape(28.dp)) {
            Text(text = "Continue",
            color = Color.White)
        }
    }
}

@Composable
fun ProblemDescriptionItem(desc: String,
                       viewModel: ProblemDescriptionViewModel,
                           id: Int,
                           modifier: Modifier) {
    val state = viewModel.getState(id).collectAsState()

    val tintColor: Color
    val backgroundColor = if (state.value) {
        tintColor = colorResource(id = R.color.selected_icon_color)
        colorResource(id = R.color.selected_bg_color)
    } else {
        tintColor = colorResource(id = R.color.un_selected_icon_color)
        colorResource(id = R.color.un_selected_bg_color)
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(BaseDpValues.ItemMinHeightMore)
            .padding(top = 16.dp),
        shape = RoundedCornerShape(28.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.border_color)),
        backgroundColor = backgroundColor,
    ) {

        Row(modifier = Modifier
            .clickable {
                viewModel.updateId(id, !state.value)
            }
            .fillMaxSize()
            .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Text(text = desc,
                color = Color.Black)

            Image(painter = painterResource(R.drawable.ic_check),
                contentDescription = "Circle Image",
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(tintColor),
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape))
        }
    }


}