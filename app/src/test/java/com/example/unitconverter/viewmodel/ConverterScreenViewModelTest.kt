package com.example.unitconverter.viewmodel

import io.kotest.matchers.shouldBe
import org.junit.Test


class ConverterScreenViewModelTest {


        @Test
        fun `converter type in validate fields in empty return true`() {
        val result = ConverterScreenViewModel().validateFields(
            "",
            "Hectare",
            "Acre",
        )
        result.shouldBe(true)
    }

        @Test
        fun `convert from in validate fields in empty return true`() {
            val result = ConverterScreenViewModel().validateFields(
                "Area",
                "",
                "Acre",
            )
            result.shouldBe(true)
    }

        @Test
        fun `convert to in validate fields in empty return true`() {
        val result = ConverterScreenViewModel().validateFields(
            "Area",
            "Acre",
            "",
        )
        result.shouldBe(true)
    }

        @Test
        fun `all fields in validate fields are empty return true`() {
        val result = ConverterScreenViewModel().validateFields(
            "",
            "",
            "",
        )
        result.shouldBe(true)
    }

        @Test
        fun `all fields in validate fields are full return false`() {
        val result = ConverterScreenViewModel().validateFields(
            "Area",
            "Hectare",
            "Acre",
        )
        result.shouldBe(false)
    }


    }