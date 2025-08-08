package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue


@Composable
fun TownMainTown(
    townName: String,
    currentTemp: Double,
    tempMax: Double,
    tempMin: Double,
    humidity: Int,
    weather: String
) {
    Text(
        text = townName,
        style = TextStyle(
            color = darkBlue,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
    )
    Spacer(
        modifier = Modifier.height(4.dp)
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(LightBlue)
            .padding(8.dp)
    ) {

        Text(
            text = "$currentTemp°",
            style = TextStyle(
                fontSize = 40.sp
            )
        )
        Row {
            Text(
                text = "$tempMax° ",
                fontSize = 26.sp
            )
            Text(text = "/ $tempMin°", fontSize = 18.sp)
        }
        Text(weather, fontSize = 20.sp)
        Text(
            "$humidity%",
            fontSize = 20.sp
        )
    }
}
