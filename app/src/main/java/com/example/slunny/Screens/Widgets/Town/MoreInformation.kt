package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.LightBlue

@Composable
fun MoreInformation(town: String) {
    Text(
        text = "Доп. Информация",
        style = TextStyle(
            color = LightBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
    )
    Column() {
        Text("")
        Text("")
    }
}