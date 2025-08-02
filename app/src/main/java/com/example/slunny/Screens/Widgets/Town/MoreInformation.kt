package com.example.slunny.Screens.Widgets.Town

import android.content.Context
import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.slunny.Data.Weather.FetchList
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue

@Composable
fun TownMoreInformation(context: Context, town: String) {

    val weather = remember { Weather(context) }
    val isLoading = weather.isLoadingList.collectAsState()
    val errorList = weather.errorMapMessage.collectAsState()
    val responseList = weather.responseMapData.collectAsState()

    LaunchedEffect(context) {
        weather.getWeatherList(town)
    }
    Text(
        text = "Информация",
        style = TextStyle(
            color = LightBlue,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        ),
        textAlign = TextAlign.Start,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    )

    when {
        isLoading.value -> CircularProgressIndicator()
        errorList.value != null -> {
            Log.d("MyLog", errorList.value.toString())
        }

        !isLoading.value && !responseList.value?.MapData.isNullOrEmpty() -> {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                itemsIndexed(
                    responseList.value!!.MapInfo.entries.toList()
                ) { index, item ->
                    InformationItem(
                        item.key, item.value
                    )

                }
            }
        }

        else -> Text("Нет данных")
    }

}

@Composable
fun InformationItem(humidity: Int, windSpeed: Double) {
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(LightBlue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("$humidity%")
        Text("$windSpeed км/ч")
    }
}