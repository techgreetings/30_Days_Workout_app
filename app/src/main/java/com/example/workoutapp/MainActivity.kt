package com.example.workoutapp



import com.example.workoutapp.model.Workout
import com.example.workoutapp.model.workoutes
import com.example.workoutapp.ui.theme.WorkoutTheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WorkoutTheme {
                Surface(modifier =Modifier.fillMaxSize()) {
                       WorkoutApp()
                }
                }
            }
        }
    }


@Composable
fun WorkoutApp(modifier: Modifier=Modifier) {
    Scaffold(topBar ={ WorkoutTopAppBar()}
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(workoutes) {
                WorkoutItem(workout = it,
                    modifier=modifier.padding(dimensionResource(id = R.dimen.padding_small)))
             
            }
        }
    }
}

@Composable
fun WorkoutItem(workout: Workout, modifier: Modifier=Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val color by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer
                     else MaterialTheme.colorScheme.primaryContainer
    )

    Card(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))) {
        Column( modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness =Spring.StiffnessMedium
                )
            ).background(color =color)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                WorkoutInformation(workoutTitle = workout.title, workoutHeading = workout.heading)
                WorkoutIcon(workoutIcon = workout.imageRes)
                Spacer(modifier = Modifier.weight(1f))
                WorkoutItemButton(expanded = expanded, onClick = { expanded = !expanded })

            }
        }
    }
    if (expanded) {
        WorkoutDescription(
            workout.description,
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_small),
                end = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_medium)
            )
        )
    }
}

@Composable
private fun WorkoutItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ){
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button),
            tint = MaterialTheme.colorScheme.secondary
        )
    }

}


@Composable
fun WorkoutIcon(modifier: Modifier=Modifier,
                @DrawableRes workoutIcon:Int){
    Image(
        modifier = modifier
            .height(350.dp)
            .fillMaxWidth()
            .padding(top = dimensionResource(id = R.dimen.padding_medium)),
        contentScale = ContentScale.Crop,

        painter = painterResource(workoutIcon),

        // Content Description is not needed here - image is decorative, and setting a null content
        // description allows accessibility services to skip this element during navigation.

        contentDescription = null,

    )
}

@Composable
fun WorkoutInformation(modifier: Modifier=Modifier,
                       @StringRes workoutTitle:Int,
                       @StringRes workoutHeading:Int){
Column (modifier=modifier){
    Text(text = stringResource(id = workoutTitle),
        modifier=modifier.padding(top = dimensionResource(id = R.dimen.padding_small)),
        style = MaterialTheme.typography.labelSmall
    )
    Text(text = stringResource(id = workoutHeading),
        style = MaterialTheme.typography.displayMedium)
}

}

@Composable
fun WorkoutDescription(
    @StringRes workoutDes:Int,
    modifier : Modifier=Modifier
){
Column(modifier=modifier) {
    Text(
        text = stringResource(R.string.workout_info),
        style = MaterialTheme.typography.labelSmall
    )
    Text(
        text = stringResource(workoutDes),
        style = MaterialTheme.typography.bodyLarge
    )
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WorkoutTopAppBar(modifier:Modifier=Modifier){
             CenterAlignedTopAppBar(title = {
                 Row(verticalAlignment = Alignment.CenterVertically){
               Image( modifier = Modifier
                   .size(100.dp)
                   .clip(RoundedCornerShape(25.dp))
                   .padding(start = 4.dp),
                   painter = painterResource(id = R.drawable.workout_logo),
                   contentDescription = null)
                     Text(
                         text = stringResource(id = R.string.app_name),
                         style = MaterialTheme.typography.displayLarge,
                         modifier = Modifier
                             .padding(start = 4.dp)
                             .padding(end = 4.dp),

                         )
             }}
                 ,modifier=modifier.padding(top = 4.dp))
}

@Preview(showBackground = true)
@Composable
fun WorkoutPreview() {
    WorkoutTheme() {
        WorkoutApp()
    }
}

@Preview
@Composable
fun WorkoutDarkThemePreview() {
    WorkoutTheme(darkTheme = true) {
        WorkoutApp()
    }
}