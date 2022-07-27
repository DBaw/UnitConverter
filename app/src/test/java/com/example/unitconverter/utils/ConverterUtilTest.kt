package com.example.unitconverter.utils

import com.example.unitconverter.viewmodel.ConverterScreenViewModel
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.Test
import java.lang.IllegalArgumentException
import java.lang.IllegalStateException
import java.util.*

class ConverterUtilTest(){

    @Test
    fun `empty string return empty list`() {
        val result = ConverterUtil.getConverterValues("")
        result.shouldBe(listOf())
    }

    @Test
    fun `area string return areas list`() {
        val result = ConverterUtil.getConverterValues("Area")
        result.shouldBe(
            listOf(
                "Hectare",
                "Acre",
                "Square Kilometre",
                "Square Metre",
                "Square Mile",
                "Square Yard",
                "Square Foot",
                "Square Inch"
            )
        )
    }

    @Test
    fun `energy string return energies list`() {
        val result = ConverterUtil.getConverterValues("Energy")
        result.shouldBe(
            listOf(
                "Joule",
                "Kilojoules",
                "Gram Calorie",
                "Kilo Calorie",
                "Watt Hour",
                "Kilowatt Hour",
                "Electron Volt",
                "British Thermal Unit",
                "US Therm",
                "Foot-Pound"
            )
        )
    }

    @Test
    fun `frequency string return frequencies list`() {
        val result = ConverterUtil.getConverterValues("Frequency")
        result.shouldBe(
            listOf(
                "Hertz",
                "Kilohertz",
                "Megahertz",
                "Gigahertz"
            )
        )
    }

    @Test
    fun `length string return lengths list`() {
        val result = ConverterUtil.getConverterValues("Length")
        result.shouldBe(
            listOf(
                "Kilometre",
                "Metre",
                "Centimetre",
                "Millimetre",
                "Micrometre",
                "Nanometre",
                "Mile",
                "Yard",
                "Foot",
                "Inch"
            )
        )
    }

    @Test
    fun `speed string return speeds list`() {
        val result = ConverterUtil.getConverterValues("Speed")
        result.shouldBe(
            listOf(
                "Miles per hour",
                "Foot per second",
                "Metre per second",
                "Kilometre per hour",
                "Knot"
            )
        )
    }

    @Test
    fun `time string return times list`() {
        val result = ConverterUtil.getConverterValues("Time")
        result.shouldBe(
            listOf(
                "Nanosecond",
                "Microsecond",
                "Millisecond",
                "Second",
                "Minute",
                "Hour",
                "Day",
                "Week",
                "Month",
                "Year",
                "Decade",
                "Century",
            )
        )
    }

    @Test
    fun `volume string return volumes list`() {
        val result = ConverterUtil.getConverterValues("Volume")
        result.shouldBe(
            listOf(
                "Gallon (US)",
                "quart (US)",
                "Pint(US)",
                "Cup (US)",
                "Fluid ounce (US)",
                "Tablespoon (US)",
                "Teaspoon (US)",
                "Cubic metre",
                "Litre",
                "Millilitre",
                "Gallon (Imp)",
                "Quart (Imp)",
                "Pint (Imp)",
                "Cup (Imp)",
                "Fluid ounce (Imp)",
                "Tablespoon (Imp)",
                "Teaspoon (Imp)",
                "Cubic foot",
                "Cubic inch"
            )
        )
    }

    @Test
    fun `weight string return weights list`() {
        val result = ConverterUtil.getConverterValues("Weight")
        result.shouldBe(
            listOf(
                "Tonne",
                "Kilogram",
                "Gram",
                "Milligram",
                "Microgram",
                "Imperial ton",
                "US ton",
                "Stone",
                "Pound",
                "Ounce"
            )
        )
    }

    @Test
    fun `convert with all fields return correct value`() {
       val result = ConverterUtil.convert(
            "Weight",
            "Tonne",
            "Milligram",
            1.0)
        result.shouldBe (1000000000)
        }
    }