package com.example.unitconverter

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@Composable
fun ExpandableCard(
    cardList: List<String>,
    textValue: String,
    labelText: String,
    scrollState: ScrollState,
    isExpanded: Boolean,
    expandedStatus: (Boolean) -> Unit = {},
    valueChange: (String) -> Unit = {}
){
    Column() {
        Box(modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colors.primary,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(
                vertical = 5.dp,
                horizontal = 10.dp
            )
            .clickable {
                expandedStatus(!isExpanded)
            }
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if(textValue.isBlank())
                    Text(
                        text = labelText,
                        color = Color.Gray
                    )
                Text(
                    text = textValue,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
                IconButton(onClick = {
                    expandedStatus(!isExpanded)
                }) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Dropdown",
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
        AnimatedVisibility(visible = isExpanded) {
            Card(
                modifier = Modifier
                    .padding(top = 1.dp),
                elevation = 6.dp,
                shape = RoundedCornerShape(10.dp),
                backgroundColor = MaterialTheme.colors.secondary

            ) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .requiredHeightIn(max = 250.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .verticalScroll(scrollState)) {
                    cardList.forEach { label ->
                        DropdownMenuItem(onClick = {
                            valueChange(label)
                            expandedStatus(false)
                        }) {
                            Text(text = label, style = MaterialTheme.typography.body1)
                        }
                    }
                }
            }
        }
    }
}

