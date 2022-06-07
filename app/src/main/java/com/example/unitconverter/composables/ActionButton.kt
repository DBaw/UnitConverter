package com.example.unitconverter.composables

import androidx.compose.runtime.Composable
import com.example.unitconverter.viewmodel.ConverterScreenViewModel

@Composable
fun ActionButton(
    viewModel: ConverterScreenViewModel,
    convertTypeText: String,
    fromText: String,
    toText: String,
    amount: String,
    onReset: () -> Unit,
    onResultVisibilityChange: (Boolean) -> Unit
){

}