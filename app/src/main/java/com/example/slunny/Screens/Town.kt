package com.example.slunny.Screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.util.Logger
import com.example.slunny.Bars.Town.TownTopAppBar
import com.example.slunny.Constants.TownData
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.Screens.Widgets.Town.TownFeedBack
import com.example.slunny.Screens.Widgets.Town.TownForCurious
import com.example.slunny.Screens.Widgets.Town.TownInformation
import com.example.slunny.Screens.Widgets.Town.TownMainTown
import com.example.slunny.Screens.Widgets.Town.TownMoreInformation
import com.example.slunny.Screens.Widgets.Town.TownWeather

@Composable
fun Town(data: TownData, controller: NavController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TownTopAppBar(controller)
        }
    ) { innerPadding ->
        val weather = remember {
            Weather(context)
        }
        var response = weather.responseData?.tempCurrent
        LaunchedEffect(context) {
            try {
                weather.getWeather(data.Name).toString().toDoubleOrNull() ?: 0.0
            } catch (e: Exception) {
                Log.d("MyLog", e.toString())
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TownMainTown(data.Name, response ?: 0.0)
            TownInformation("Неизвестно")
            TownFeedBack()
            TownWeather(context, data.Name)
            TownMoreInformation(context, data.Name)
            TownForCurious(context, data.Name)
        }
    }
}