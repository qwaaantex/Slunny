package com.example.slunny.Screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.util.Logger
import com.example.slunny.Bars.Town.TownInformationSnackBar
import com.example.slunny.Bars.Town.TownTopAppBar
import com.example.slunny.Constants.TownData
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.Screens.Widgets.Town.TownFeedBack
import com.example.slunny.Screens.Widgets.Town.TownForCurious
import com.example.slunny.Screens.Widgets.Town.TownInformation
import com.example.slunny.Screens.Widgets.Town.TownMainTown
import com.example.slunny.Screens.Widgets.Town.TownMoreInformation
import com.example.slunny.Screens.Widgets.Town.TownWeather
import com.example.slunny.ui.theme.LightBlue
import kotlinx.coroutines.launch

@Composable
fun Town(data: TownData, controller: NavController) {
    val context = LocalContext.current
    val weather = remember {
        Weather(context)
    }
    var tempData = weather.responseTemperature
    var errorTemp = weather.errorTemperature
    var loadingTemp = weather.isLoadingTemperature
    val host = remember { SnackbarHostState() }
    val coroutine = rememberCoroutineScope()
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = host) { data ->
                TownInformationSnackBar(data)
            }
        },
        topBar = {
            TownTopAppBar(controller)
        }
    ) { innerPadding ->
        var response = weather.responseData?.tempCurrent
        LaunchedEffect(context) {
            try {
                weather.getWeather(data.Name).toString().toDoubleOrNull() ?: 0.0
                weather.getWeatherTemperature(data.Name)
            } catch (e: Exception) {
                Log.d("MyLog", e.toString())
            }
            coroutine.launch {
                host.showSnackbar(
                    message = "Прогноз не всегда бывает точным," +
                            " поэтому оставьте ваше мнение!"
                )
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            when {
                loadingTemp -> CircularProgressIndicator(
                    color = LightBlue
                )

                errorTemp != null -> Log.d("MyLog", errorTemp)
                tempData != null -> {
                    TownMainTown(
                        data.Name,
                        response ?: 0.0,
                        tempData.tempMax,
                        tempData.tempMin,
                        tempData.humidity,
                        tempData.weather
                    )
                }

                else -> Text(
                    "Нет данных",
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                )
            }
            TownInformation("Описание может быть добавлено в скором времени")
            TownFeedBack()
            TownWeather(context, data.Name)
            TownMoreInformation(context, data.Name)
            TownForCurious(context, data.Name)
        }
    }
}