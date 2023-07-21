package com.converter.unit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


//topappbar use 135 padding


@Composable
fun UpperPanel(nvCntrl: NavHostController) {
    //val context= LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Blue) , horizontalArrangement = Arrangement.Center){
            Text(text = stringResource(id = R.string.app_name), fontSize = 35.sp, color = Color.White)
        }
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){

                Image(painter = painterResource(id = R.drawable.length), contentDescription = "",modifier = Modifier
                    .size(88.dp, 89.dp)
                    .clickable(onClick = { nvCntrl.navigate(LengthConverter.route) }))

                Image(painter = painterResource(id = R.drawable.mass), contentDescription = "",modifier = Modifier
                    .size(88.dp, 89.dp)
                    .clickable(onClick = { nvCntrl.navigate(MassConverter.route) }))

                Image(painter = painterResource(id = R.drawable.temp), contentDescription = "", modifier = Modifier
                    .size(88.dp, 89.dp)
                    .clickable(onClick = { nvCntrl.navigate(TempConverter.route) }))

        }
    }

}

