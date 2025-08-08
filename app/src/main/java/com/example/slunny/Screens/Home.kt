package com.example.slunny.Screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slunny.Bars.Home.HomeTopAppBar
import com.example.slunny.Constants.TownData
import com.example.slunny.Data.Location.FetchLocation
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.Screens.Widgets.Home.HomeMainTown
import com.example.slunny.Screens.Widgets.Home.HomeRefresh
import com.example.slunny.Screens.Widgets.Home.HomeSearch
import com.example.slunny.Screens.Widgets.Home.HomeTowns
import com.example.slunny.ui.theme.darkBlue


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    controller: NavController,
) {
    val context = LocalContext.current
    var searchText by remember { mutableStateOf("") }

    var active by remember { mutableStateOf(false) }
    val weather = remember { Weather(context) }
    var error = weather.errorMessage
    var loading = weather.isLoading
    var response = weather.responseData

    val location = remember { FetchLocation() }

    var city = location.city
    LaunchedEffect(context) {
        location.getCity(context)
        try {
            weather.getWeather(city ?: "Москва")
        } catch (e: Exception) {
            Log.d("MyLog", e.toString())
        }
    }
    val isGeoPermission = location.isPermissionGranted
    Scaffold(
        floatingActionButton = {
            HomeRefresh()
        },
        topBar = { HomeTopAppBar() }
    ) { innerPadding ->
        if (isGeoPermission) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                when {
                    loading -> CircularProgressIndicator()
                    error != null -> {
                        CircularProgressIndicator()
                        Log.d("MyLog", error.toString())
                    }

                    !loading && response != null -> HomeMainTown(
                        city ?: "Неизвестно",
                        response.tempCurrent,
                        context
                    )
                }
                HomeSearch(searchText, active) { town ->
                    controller.navigate(TownData(town))
                }
                HomeTowns(controller, context)
            }
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        color = darkBlue
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        style = TextStyle(
                            fontSize = 16.sp,
                            color = Color.Gray
                        ),
                        textAlign = TextAlign.Center,
                        text =
                            "Перейдите в настройки приложения, чтобы возобновить работу его разрешений",
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}