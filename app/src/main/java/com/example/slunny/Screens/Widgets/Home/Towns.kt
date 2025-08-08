package com.example.slunny.Screens.Widgets.Home

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.slunny.Constants.Lists
import com.example.slunny.Constants.TownData
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue


@Composable
fun HomeTowns(
    controller: NavController,
    context: Context
) {
    Column {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(items = Lists.Towns) { index, item ->
                val weather = remember { Weather(context) }
                HomeTownItem(item, controller, index, weather)
            }
        }
    }
}

@Composable
fun HomeTownItem(item: String, controller: NavController, index: Int, weather: Weather) {
    LaunchedEffect(item) {
        weather.getWeather(item)
    }
    val data = weather.responseData
    val error = weather.errorMessage
    val isLoading = weather.isLoading

    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(vertical = 5.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    tint = LightBlue,
                    contentDescription = null
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("${data?.tempFeels ?: "Загрузка..."}°",
                        modifier = Modifier.padding(6.dp),
                        style = TextStyle(color = darkBlue, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            maxLines = 1,
                            modifier = Modifier.fillMaxWidth(0.65f),
                            text = item,
                            textAlign = TextAlign.Center,
                            overflow = TextOverflow.Ellipsis,
                            style = TextStyle(
                                color = LightBlue,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        when {
                            isLoading ->
                                CircularProgressIndicator(
                                    color = LightBlue
                                )

                            error != null ->
                                Text("Ошибка")

                            data != null ->
                                Text(
                                    text = "${data.tempCurrent}°",
                                    textAlign = TextAlign.Center,
                                    style = TextStyle(
                                        fontSize = 17.sp,
                                        fontWeight = FontWeight.W400
                                    )
                                )

                            else ->
                                Text("Нет данных")
                        }
                    }
                    if (data?.ImageUrl != null) AsyncImage(
                        modifier = Modifier.padding(2.dp).size(35.dp),
                        model = "https:${data.ImageUrl}",
                        contentDescription = null
                    )
                }
                IconButton(
                    onClick = {
                        try {
                            controller.navigate(
                                TownData(
                                    Name = item,
                                )
                            )
                        } catch (e: Exception) {
                            Log.d("MyLog", e.toString())
                        }
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowRight,
                        contentDescription = null,
                        tint = LightBlue
                    )
                }
            }
        }
        if (index == Lists.Towns.size) {
            Spacer(
                modifier = Modifier.height(2.dp)
            )
        }
    }
}