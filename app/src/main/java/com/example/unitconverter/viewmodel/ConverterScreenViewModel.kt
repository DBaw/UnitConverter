package com.example.unitconverter.viewmodel

import androidx.lifecycle.ViewModel
import com.example.unitconverter.utils.ConverterUtil
import com.example.unitconverter.utils.ConverterUtil.CONVERTER_TYPES
import androidx.compose.runtime.mutableStateOf


class ConverterScreenViewModel : ViewModel() {

    val converterTypes = CONVERTER_TYPES
    val result = mutableStateOf(0.0f)



    fun getConverterValues(
        converterType: String
    ): List<String>{
        return ConverterUtil.getConverterValues(converterType = converterType)
    }

    fun calculateResult(
        convertType: String,
        convertFrom: String,
        convertTo: String,
        amount: Double = 0.0
    ){
        result.value = ConverterUtil.convert(
            converterType = convertType,
            convertFrom = convertFrom,
            convertTo = convertTo,
            amount = amount
        ).toBigDecimal().toFloat()
    }
}