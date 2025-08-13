package com.example.slunny.Bars.Home

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slunny.Constants.Info
import com.example.slunny.Constants.LikelyTowns
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(controller: NavController) {
    TopAppBar(
        modifier = Modifier.fillMaxWidth(),
        navigationIcon = {
            IconButton(onClick = {
                controller.navigate(Info)
            }) {
                Icon(
                    tint = LightBlue,
                    imageVector = Icons.Default.Info, contentDescription = null
                )
            }
        },
        title = {
            Text(
                text = "Ваша геопозиция",
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(),
                style = TextStyle(
                    color = LightBlue,
                    fontSize = 21.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },

        actions = {
            IconButton(onClick = {
                controller.navigate(LikelyTowns)
            }) {
                Icon(
                    tint = LightBlue,
                    imageVector = Icons.Default.Star, contentDescription = ""
                )
            }
        }
    )
}