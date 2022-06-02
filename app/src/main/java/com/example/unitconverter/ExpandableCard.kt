package com.example.unitconverter

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.Shapes

@ExperimentalMaterialApi
@Composable
fun expandableCard(){
    var expandableState by remember {
        mutableStateOf(false)
    }
    val rotationState by animateFloatAsState(
        targetValue = if (expandableState) 180f else 0f
    )
    var titleState by remember {
        mutableStateOf("")
    }



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(16.dp),
        shape = Shapes.medium,
        onClick = {
            expandableState = !expandableState
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = titleState,
                    modifier = Modifier.weight(6f)
                        .padding(start = 52.dp),
                    fontSize = MaterialTheme.typography.h6.fontSize,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = { expandableState = !expandableState }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop Down Arrow"
                    )
                }
            }
        }
    }
}

