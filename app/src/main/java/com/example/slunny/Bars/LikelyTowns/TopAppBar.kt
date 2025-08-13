package com.example.slunny.Bars.LikelyTowns

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slunny.ui.theme.LightBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikelyTownsTopAppBar(controller: NavController) {
    TopAppBar(
        actions = {
            IconButton(onClick = {

            }) {
                Icon(tint = LightBlue,
                    contentDescription = null,
                    imageVector = Icons.Default.Star
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                controller.popBackStack()
            }) {
                Icon(
                    tint = LightBlue,
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        },
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                text =
                    "Избранные",
                fontSize = 19.sp, fontWeight = FontWeight.Bold, color = LightBlue
            )
        }
    )
}