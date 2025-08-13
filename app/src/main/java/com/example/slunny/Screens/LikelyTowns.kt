package com.example.slunny.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.slunny.Bars.LikelyTowns.LikelyTownsTopAppBar
import com.example.slunny.Screens.Widgets.LikelyTowns.LikelyTownsListTowns
import com.example.slunny.Screens.Widgets.LikelyTowns.LikelyTownsSearch

@Composable
fun LikelyTowns(controller: NavController) {
    Scaffold(
        topBar = {
            LikelyTownsTopAppBar(controller)
        }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(padding).verticalScroll(
                rememberScrollState()
            )
        ) {
            LikelyTownsSearch()
            LikelyTownsListTowns()
        }

    }
}