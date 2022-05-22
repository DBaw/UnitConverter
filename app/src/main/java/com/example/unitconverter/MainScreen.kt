package com.example.unitconverter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun MainScreen(){
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {

    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp)) {

        Text(
            text = "UNIT CONVERTER",
            fontSize = 24.sp,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        Text(
            text = "Choose Unit",
            fontSize = 24.sp,
            color = MaterialTheme.colors.onBackground,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        val getAllUnits = UnitRepository().getAllUnits()

        val getAllMasses = MassRepository().getAllUnits()

        val getAllDistances = DistanceRepository().getAllUnits()

        val getAllTimes = TimeRepository().getAllUnits()

        var unitState by remember {
            mutableStateOf("MASS")
        }

         unitState = ExpandableCard(getAllUnits)

        Row(modifier = Modifier.fillMaxWidth()){
            ExpandableCard(when(unitState){
                "MASS" -> getAllMasses
                "DISTANCE"->getAllMasses
                else -> getAllTimes
            })
            ExpandableCard(when(unitState){
                "MASS" -> getAllMasses
                "DISTANCE"->getAllMasses
                else -> getAllTimes
            })
        }



}
    }
}