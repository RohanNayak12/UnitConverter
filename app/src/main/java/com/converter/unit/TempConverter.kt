package com.converter.unit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TempConverter(nvCntrl: NavHostController) {
    Scaffold(topBar = { UpperPanel(nvCntrl) }) {it
        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = 140.dp)) {
            Text(text = "Temperature Unit Conversions", color = Color.Black,fontSize=34.sp, modifier = Modifier.padding(start = 13.dp))
            InputTaker(List = TempList)
            TempCal()
        }
    }
}


@Composable
fun TempCal(){
    var textResult by remember { mutableStateOf("0.0") }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(15.dp), horizontalArrangement = Arrangement.Center) {
        Button(onClick = { ResultAnswer= CelsiusToConverter(
            TempConverterToCelsuis(unitValue,
            firstUnit), secondUnit)
            textResult= ResultAnswer.toString()}, colors = ButtonDefaults.buttonColors(Color.Blue)) {
            Text(text = "Convert", color = Color.White)
        }
    }

    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 35.dp), horizontalArrangement = Arrangement.Center) {
        Text(text = "$textResult  $secondUnit", fontSize = 35.sp , fontWeight = FontWeight.Bold, color = Color.Black)
    }
}