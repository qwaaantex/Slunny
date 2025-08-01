package com.example.slunny.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.slunny.Bars.Town.TownTopAppBar
import com.example.slunny.Constants.TownData
import com.example.slunny.Screens.Widgets.Town.TownFeedBack
import com.example.slunny.Screens.Widgets.Town.TownInformation
import com.example.slunny.Screens.Widgets.Town.TownMainTown
import com.example.slunny.Screens.Widgets.Town.TownWeather

@Composable
fun Town(data: TownData, controller: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(
        topBar = {
            TownTopAppBar(controller)
        }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            TownMainTown(data.Name, data.Temp)
            TownInformation("Неизвестно")
            TownFeedBack()
            TownWeather(LocalContext.current, data.Name)
        }
    }
}