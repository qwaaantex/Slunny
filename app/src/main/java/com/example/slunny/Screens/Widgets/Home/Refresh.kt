package com.example.slunny.Screens.Widgets.Home


import android.content.Context
import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue

@Composable
fun HomeRefresh(context: Context, town: String) {
    val weather = remember {
        Weather(context = context)
    }
    IconButton(
        colors = IconButtonColors(
            containerColor = LightBlue,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = LightBlue
        ),
        onClick = {
           try {
               weather.getWeather(town)
           } catch(e: Exception) {
               Log.d("MyLog", e.toString())
           }
        }) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = null
        )
    }
}