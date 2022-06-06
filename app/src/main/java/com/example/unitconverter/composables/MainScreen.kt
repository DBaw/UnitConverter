package com.example.unitconverter

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import com.example.unitconverter.viewmodel.ConverterScreenViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: ConverterScreenViewModel = viewModel()
) {
    val scrollState = rememberScrollState()
    var expanded by remember {
        mutableStateOf("")
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }

}