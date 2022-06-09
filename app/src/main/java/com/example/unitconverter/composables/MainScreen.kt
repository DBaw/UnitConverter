package com.example.unitconverter


import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconverter.viewmodel.ConverterScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unitconverter.composables.ActionButtons
import com.example.unitconverter.composables.Result


@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun MainScreen(
    viewModel: ConverterScreenViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    var expanded by remember {
        mutableStateOf(listOf(false, false, false))
    }
    var converterTypeText by remember {
        mutableStateOf("")
    }
    var fromText by remember {
        mutableStateOf("")
    }
    var toText by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }
    var result by remember {
        viewModel.result
    }
    var error by remember {
        mutableStateOf(false)
    }
    var resultantStringVisibility by remember {
        mutableStateOf(false)
    }
    val animatedResult by animateFloatAsState(
        targetValue = result,
        animationSpec = tween(500)
    )

    val softKeyboardFocusManager = LocalFocusManager.current
    val converterTypes = viewModel.converterTypes
    val converterValues = viewModel.getConverterValues(converterTypeText)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier
                    .align(Alignment.Start),
                text = "UNIT\nCONVERTER",
                style = TextStyle(
                    fontWeight = FontWeight.Black,
                    fontSize = 30.sp,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            )
            Spacer(modifier = Modifier.height(20.dp))

            ExpandableCard(
                cardList = converterTypes,
                textValue = converterTypeText,
                labelText = "Converter Type",
                scrollState = scrollState,
                isExpanded = expanded[0],
                expandedStatus = {
                    expanded = listOf(it, false, false)
                },
                valueChange = {
                    resultantStringVisibility = false
                    converterTypeText = it
                    fromText = ""
                    toText = ""
                    amount = ""

                }
            )
            Spacer(modifier = Modifier.height(30.dp))

            ExpandableCard(
                cardList = converterValues,
                textValue = fromText,
                labelText = "Convert From",
                scrollState = scrollState,
                isExpanded = expanded[1],
                expandedStatus = {
                    if (converterTypeText.isNotEmpty()) {
                        expanded = listOf(false, it, false)
                    }
                },
                valueChange = {
                    fromText = it
                }
            )
            Spacer(modifier = Modifier.height(5.dp))

            IconButton(
                onClick = {
                    resultantStringVisibility = false
                    fromText = toText.also {
                        result = 0.0f
                    }
                },
                enabled = fromText.isNotBlank() && toText.isNotBlank()
            ) {
                Icon(
                    imageVector = Icons.Default.SwapVert,
                    contentDescription = "Swap Units",
                    modifier = Modifier.size(30.dp),
                    tint = MaterialTheme.colors.primary
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            ExpandableCard(
                cardList = converterValues,
                textValue = toText,
                labelText = "Convert To",
                scrollState = scrollState,
                isExpanded = expanded[2],
                expandedStatus = {
                    if (converterTypeText.isNotEmpty()) {
                        expanded = listOf(false, false, it)
                    }
                },
                valueChange = {
                    toText = it
                }
            )
            Spacer(modifier = Modifier.height(15.dp))

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = amount,
                onValueChange = {
                    amount = it
                },
                label = {
                    Text(
                        text = "Amount",
                        color = Color.Gray
                    )
                },
                placeholder = {
                    Text(
                        text = "0.0",
                        color = Color.Gray
                    )
                },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        softKeyboardFocusManager.clearFocus()
                    }
                ),
                enabled = toText.isNotBlank(),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = if (isSystemInDarkTheme()) Color.White else Color.Black,
                    errorBorderColor = Color.Red
                ),
                isError = !viewModel.validateAmount(amount)
            )

            Spacer(modifier = Modifier.height(20.dp))

            //Buttons
            ActionButtons(
                viewModel = viewModel,
                convertTypeText = converterTypeText,
                fromText = fromText,
                toText = toText,
                amount = amount,
                onReset = {
                    converterTypeText = ""
                    fromText = ""
                    toText = ""
                    amount = ""
                }
            ) {
                resultantStringVisibility = it
            }

            Spacer(modifier = Modifier.height(20.dp))

            //Results
            if (resultantStringVisibility)
                Result(value = animatedResult, unit = toText)

            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}