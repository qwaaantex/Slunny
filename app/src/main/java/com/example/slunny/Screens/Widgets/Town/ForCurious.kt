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
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
fun TownForCurious(context: Context, town: String) {
    val weather = remember { Weather(context) }
    LaunchedEffect(context) {
        weather.getWeatherList(town)
    }
    val responseData = weather.responseMapData?.MapCurious
    val error = weather.errorMapMessage
    val isLoading = weather.isLoadingList
    Text(
        "Для любознательных",
        textAlign = TextAlign.Start,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        style = TextStyle(
            color = LightBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
    )
    when {
        isLoading -> CircularProgressIndicator()
        error != null -> Text("Ошибка")
        !responseData.isNullOrEmpty() && !isLoading -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                itemsIndexed(responseData.entries.toList())
                {
                    index, item -> TownCuriosItem(item.key, item.value)
                }
            }
        }
        else -> Text("Нет данных")
    }
}

@Composable

fun TownCuriosItem(precip: Double, vis: Double) {
    Column(
        modifier = Modifier.clip(RoundedCornerShape(8.dp)).background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("$precip мм")
        Text("$vis км/ч")
    }
}