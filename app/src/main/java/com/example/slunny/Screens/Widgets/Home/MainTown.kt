package com.example.slunny.Screens.Widgets.Home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.LightBlue

@Composable
fun HomeMainTown(
    town: String,
    temp: Double,
    weather: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = town,
            style = TextStyle(fontSize = 30.sp, color = Color.Black, fontWeight = FontWeight.Bold)
        )
        Box(modifier = Modifier.fillMaxHeight(0.01f))
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .clip(RoundedCornerShape(16.dp))
                .background(LightBlue),
        )
        {
            Text(
                modifier = Modifier.padding(2.dp),
                text = "$temp°", style = TextStyle(fontSize = 50.sp)
            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "28° ",
                    style = TextStyle(color = Color.Black, fontSize = 22.sp)
                )
                Text(
                    text = "/ 19°",
                    style = TextStyle(color = Color.Black, fontSize = 18.sp)
                )
            }
            Text(
                modifier = Modifier.padding(2.dp),
                text = weather, style = TextStyle(
                    color = Color.Black,
                    fontSize = 20.sp
                )
            )
        }
    }
}