package com.example.slunny.Screens.Widgets.Town

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue

@Composable
fun TownWeather(
    context: Context,
    town: String,
) {
    val weather = remember { Weather(context) }
    var list = weather.responseMapData.collectAsState()
    var loading = weather.isLoadingList.collectAsState()
    val error = weather.errorMapMessage.collectAsState()

    LaunchedEffect(town) {
        weather.getWeatherList(town)
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
            loading.value -> {
                item {
                    CircularProgressIndicator(
                        color = LightBlue
                    )
                }
            }

            error.value != null -> {
                item {
                    Text("Ошибка")
                }
            }

            !loading.value && !list.value?.MapData.isNullOrEmpty() -> {
                itemsIndexed(list.value!!.MapData.keys.toList()) { index, item ->
                    val temp = list.value?.MapData?.getValue(item) ?: 0.0
                    WeatherItem(item, temp)
                }
            }

            else -> item {
                Text("Нет данных")
            }
        }
    }
}

@Composable
fun WeatherItem(item: String, temp: Double) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(item)
        Text(text = "$temp°")
    }
}