package com.example.slunny.Screens.Widgets.Town

import android.content.Context
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue

@Composable
fun TownWeather(
    context: Context,
    town: String,
) {
    val weather = remember { Weather(context) }
    var list = weather.responseMapData
    var loading = weather.isLoadingList
    val error = weather.errorMapMessage

    LaunchedEffect(town) {
        try {
            weather.getWeatherList(town)
        } catch (e: Exception) {
            Log.d("MyLog", e.toString())
        }
    }
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 8.dp),
        text = "Прогноз",
        style = TextStyle(
            fontSize = 30.sp,
            color = LightBlue,
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.Start
    )
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        modifier = Modifier.padding(8.dp)
    ) {

        when {
            loading -> {
                item {
                    CircularProgressIndicator(
                        color = LightBlue
                    )
                }
            }

            error != null -> {
                item {
                    Text("Ошибка")
                }
            }

            !loading && !list?.MapData.isNullOrEmpty() -> {
                itemsIndexed(list.MapData.keys.toList()) { index, item ->
                    val temp = list.MapData.getValue(item)
                    WeatherItem(
                        item,
                        temp,
                    )
                }
            }

            else -> item {
                Text("Нет данных")
            }
        }
    }
}

@Composable
fun WeatherItem(
    item: String,
    temp: Double,
) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(item)
        Text(text = "$temp°")
    }
}