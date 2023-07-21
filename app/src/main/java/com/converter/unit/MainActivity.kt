package com.converter.unit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Nav()

        }
    }
}
@Composable
fun Nav(){
    val nvCntrl= rememberNavController()
    NavHost(navController = nvCntrl, startDestination = LengthConverter.route ){
        composable(LengthConverter.route){ LengthConverter(nvCntrl)}
        composable(MassConverter.route){ MassConverter(nvCntrl)}
        composable(TempConverter.route){ TempConverter(nvCntrl)}
        composable(NavControl.route){ UpperPanel(nvCntrl)}
    }
}

