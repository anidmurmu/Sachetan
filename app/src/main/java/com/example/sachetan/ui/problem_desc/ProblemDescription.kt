package com.example.sachetan.ui.problem_desc

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.dp
import com.example.sachetan.R
import com.example.sachetan.ui.base_compose.units.BaseDpValues
import com.example.sachetan.ui.base_compose.units.BasePadding

@Composable
fun ProblemDescriptionScreen(viewModel: ProblemDescriptionViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = BasePadding.Default),
        verticalArrangement = Arrangement.Center
    ) {
        ProblemBurnOutItem("Feeling Burnt Out", viewModel, {}, Modifier)
        ProblemStressedItem("Feeling Stressed", viewModel, {}, Modifier)
        ProblemAnxietyItem("Manage Anxiety", viewModel, {}, Modifier)
        ProblemCalmItem("Be Calm", viewModel, {}, Modifier)
        ProblemSomethingItem("Something Else", viewModel, {}, Modifier)
    }
}


@Composable
fun ProblemBurnOutItem(desc: String,
                    viewModel: ProblemDescriptionViewModel,
                    onClick: () -> Unit, modifier: Modifier) {
    val burnOutState = viewModel.problemViewState.burntOut.collectAsState()

    val tintColor: Color
    val backgroundColor = if (burnOutState.value) {
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
                        viewModel.updateId(ProblemViewState.BURNT_OUT_ID, !burnOutState.value)
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

@Composable
fun ProblemStressedItem(desc: String,
                       viewModel: ProblemDescriptionViewModel,
                       onClick: () -> Unit, modifier: Modifier) {

    val stressed = viewModel.problemViewState.stressed.collectAsState()
    val tintColor: Color
    val backgroundColor = if (stressed.value) {
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
                viewModel.updateId(ProblemViewState.STRESSED_ID, !stressed.value)
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

@Composable
fun ProblemAnxietyItem(desc: String,
                       viewModel: ProblemDescriptionViewModel,
                       onClick: () -> Unit, modifier: Modifier) {

    val anxiety = viewModel.problemViewState.anxiety.collectAsState()
    val tintColor: Color
    val backgroundColor = if (anxiety.value) {
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
                viewModel.updateId(ProblemViewState.ANXIETY_ID, !anxiety.value)
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

@Composable
fun ProblemCalmItem(desc: String,
                       viewModel: ProblemDescriptionViewModel,
                       onClick: () -> Unit, modifier: Modifier) {

    val calm = viewModel.problemViewState.calm.collectAsState()
    val tintColor: Color
    val backgroundColor = if (calm.value) {
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
                viewModel.updateId(ProblemViewState.CALM_ID, !calm.value)
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

@Composable
fun ProblemSomethingItem(desc: String,
                       viewModel: ProblemDescriptionViewModel,
                       onClick: () -> Unit, modifier: Modifier) {

    val something = viewModel.problemViewState.something.collectAsState()
    val tintColor: Color

    val backgroundColor = if (something.value) {
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
                viewModel.updateId(ProblemViewState.SOMETHING_ID, !something.value)
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