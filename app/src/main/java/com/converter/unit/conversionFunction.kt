@file:OptIn(ExperimentalMaterial3Api::class)

package com.converter.unit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun InputTaker(List:List<String>){

    var dropLengthText1 by remember { mutableStateOf("Choose Value") }
    var dropLengthText2 by remember { mutableStateOf("Choose Value") }
    var dropState1 by remember { mutableStateOf(false) }
    var dropState2 by remember { mutableStateOf(false) }
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 13.dp), horizontalArrangement = Arrangement.Center) {
        var textval by remember { mutableStateOf("") }
        TextField(value = textval, onValueChange = { unitValue=it.toDouble()
            textval=it}
            , label = { Text(text = "Enter numerical value") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
        )
    }
    Row(Modifier.padding(start = 13.dp, top = 20.dp)) {
        Text(text = "First Unit", modifier = Modifier.padding(top = 17.dp))
        Box(modifier = Modifier.padding(start=41.dp)) {
            ExposedDropdownMenuBox(expanded = dropState1, onExpandedChange = {dropState1=!dropState1}) {
                TextField(value = dropLengthText1, onValueChange = { }, readOnly = true,trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropState1) },modifier = Modifier.menuAnchor())
                ExposedDropdownMenu(expanded = dropState1, onDismissRequest = { dropState1=false }) {
                    List.forEach { item->
                        DropdownMenuItem(text = { Text(text = item) }, onClick = { dropLengthText1=item
                            dropState1=false
                            firstUnit=item})
                    }
                }
            }
        }

    }
    Row(Modifier.padding(start = 13.dp,top=15.dp)) {
        Text(
            text = "Second Unit",
            modifier = Modifier.padding(top = 17.dp)
        )
        Box(modifier = Modifier.padding(start=25.dp)) {
            ExposedDropdownMenuBox(
                expanded = dropState2,
                onExpandedChange = { dropState2 = !dropState2 }) {
                TextField(
                    value = dropLengthText2,
                    onValueChange = { },
                    readOnly = true,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(
                            expanded = dropState2
                        )
                    },
                    modifier = Modifier.menuAnchor()
                )
                ExposedDropdownMenu(
                    expanded = dropState2,
                    onDismissRequest = { dropState2 = false }) {
                    List.forEach { item ->
                        DropdownMenuItem(text = {
                            Text(
                                text = item
                            )
                        }, onClick = {
                            dropLengthText2 = item
                            dropState2 = false
                            secondUnit = item
                        })
                    }
                }
            }
        }

    }

}




//For Length
fun lengthConverterToMeter(base:Double,unit:String):Double{
    when(unit){
        LenghtList[0]->{return base*1}
        LenghtList[1]->{return base/3.281}
        LenghtList[2]->{return base/1.094}
        LenghtList[3]->{return base*1609}
        LenghtList[4]->{return base/39.37}
        LenghtList[5]->{return base*1852}
        else->{return base}
    }
}
fun MeterToConverter(base: Double,unit: String):Double{
    when(unit){
        LenghtList[0]->{return base*1}
        LenghtList[1]->{return base*3.281}
        LenghtList[2]->{return base*1.094}
        LenghtList[3]->{return base/1609}
        LenghtList[4]->{return base*39.37}
        LenghtList[5]->{return base/1852}
        else->{return base}
    }
}


//For Mass
fun MassConverterToKg(base:Double,unit: String):Double{
    when(unit){
        MassList[0]->{return base*1}
        MassList[1]->{return base/2.205}
        MassList[2]->{return base/35.274}
        MassList[3]->{return base/1000}
        MassList[4]->{return base*1000}
        else->{return base}
    }
}
fun KgToConverter(base:Double,unit: String):Double{
    when(unit){
        MassList[0]->{return base*1}
        MassList[1]->{return base*2.205}
        MassList[2]->{return base*35.274}
        MassList[3]->{return base*1000}
        MassList[4]->{return base/1000}
        else->{return base}
    }
}


//For Temperature
fun TempConverterToCelsuis(base:Double,unit: String):Double{
    when(unit){
        TempList[0]->{return base}
        TempList[1]->{return ((base-32)*(5/9))}
        TempList[2]->{return (base-273.15)}
        else->{return base}
    }
}
fun CelsiusToConverter(base:Double,unit: String):Double{
    when(unit){
        TempList[0]->{return base}
        TempList[1]->{return (base*(9/5))+32}
        TempList[2]->{return (base+273.15)}
        else->{return base}
    }
}