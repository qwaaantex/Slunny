package com.example.slunny.Bars.Town

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.navigation.NavController
import com.example.slunny.Data.Weather.Weather
import com.example.slunny.R
import com.example.slunny.Screens.Widgets.Town.WeatherItem


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TownTopAppBar(navController: NavController, context: Context, town: String) {
    val weather = remember {
        Weather(context = context)
    }
    TopAppBar(
        title = {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                IconButton(
                    onClick = {
                        weather.getWeather(town)
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_autorenew_24),
                        contentDescription = null
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        },
        actions = {
            IconButton(onClick = {

            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_share_location_24),
                    contentDescription = null
                )
            }
        }
    )
}