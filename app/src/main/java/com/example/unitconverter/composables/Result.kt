package com.example.unitconverter.composables

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun Result(
    value: Float,
    unit: String
){
    Text(text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = MaterialTheme.colors.primary,
                fontSize = 30.sp,
                fontWeight = FontWeight.Medium
            )
        ){
            append("$value")
        }
        append("\t\t")
        withStyle(style = SpanStyle(
            color = MaterialTheme.colors.primary.copy(
                alpha = 0.8f
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium
        )
        ){
            append("$unit")
        }
    })
}