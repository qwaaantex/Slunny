package com.example.slunny.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.slunny.Bars.Info.InfoTopAppBar
import com.example.slunny.Screens.Widgets.Info.InfoInformation
import com.example.slunny.Screens.Widgets.Info.InfoMainText
import com.example.slunny.Screens.Widgets.Info.InfoQuestions
import com.example.slunny.Screens.Widgets.Info.InfoSupport

@Composable
fun Info(controller: NavController) {
    Scaffold(
        topBar = {
            InfoTopAppBar(controller)
        }
    ) { padding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(padding).fillMaxSize()
                .verticalScroll(rememberScrollState()),

        ) {
            InfoMainText("Slunny")
            Spacer(modifier = Modifier.height(6.dp))
            InfoInformation()
            Spacer(modifier = Modifier.height(6.dp))
            InfoSupport()
            Spacer(modifier = Modifier.height(6.dp))
            InfoQuestions()
        }
    }
}