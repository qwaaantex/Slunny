package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.darkBlue


@Composable
fun TownMainTown(
    townName: String,
    currentTemp: Double
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
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
        Text(
            text = "$currentTemp°",
            style = TextStyle(
                fontSize = 34.sp
            )
        )
    }
}
