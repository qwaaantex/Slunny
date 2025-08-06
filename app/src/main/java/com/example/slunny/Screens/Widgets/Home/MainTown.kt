package com.example.slunny.Screens.Widgets.Home

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@Composable
fun HomeMainTown(
    town: String,
    temp: Double,
    context: Context
) {
    val weatherData = remember { Weather(context = context) }
    val temperature = weatherData.responseTemperature
    val temperatureError = weatherData.errorTemperature
    val temperatureLoading = weatherData.isLoadingTemperature

    LaunchedEffect(town) {
        try {
            weatherData.getWeatherTemperature(town)
        } catch (e: Exception) {
            Log.d("MyLog", e.toString())
        }
    }

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
            if (!temperatureLoading && temperatureError == null) {
                when {
                    temperature != null -> {
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "${temperature.tempMax}° ",
                                style = TextStyle(color = Color.Black, fontSize = 22.sp)
                            )
                            Text(
                                text = "/ ${temperature.tempMin}°",
                                style = TextStyle(color = Color.Black, fontSize = 18.sp)
                            )
                        }
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = temperature.weather, style = TextStyle(
                                color = Color.Black,
                                fontSize = 20.sp
                            )
                        )
                    }

                    else -> {
                        Text("Нет данных")
                    }

                }

            } else {
                CircularProgressIndicator(
                    modifier = Modifier.padding(6.dp),
                    color = darkBlue
                )
            }
        }
    }
}