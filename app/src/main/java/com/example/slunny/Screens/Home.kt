package com.example.slunny.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.slunny.Bars.Home.HomeTopAppBar
import com.example.slunny.Screens.Widgets.Home.HomeMainTown
import com.example.slunny.Screens.Widgets.Home.HomeRefresh
import com.example.slunny.Screens.Widgets.Home.HomeSearch
import com.example.slunny.Screens.Widgets.Home.HomeTowns


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(controller: NavController) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    var searchText by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            HomeRefresh()
        },
        topBar = { HomeTopAppBar() }
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            HomeMainTown("Москва", 21, "Солнечно")
            HomeSearch(searchText, active)
            HomeTowns(controller, context)
        }
    }
}