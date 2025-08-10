package com.example.slunny.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.slunny.Bars.Info.InfoTopAppBar

@Composable
fun Info(controller: NavController) {
    Scaffold(
        topBar = {
            InfoTopAppBar(controller)
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {
        }
    }
}