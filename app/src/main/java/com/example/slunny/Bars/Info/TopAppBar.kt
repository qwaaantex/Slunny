package com.example.slunny.Bars.Info

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.slunny.R
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoTopAppBar(controller: NavController) {

    TopAppBar(
        title = {
            Text(
                "Информация",
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
            IconButton(
                onClick = {},

                ) {
                Icon(
                    tint = LightBlue,
                    painter = painterResource(R.drawable.baseline_wb_sunny_24),
                    contentDescription = null
                )
            }
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    controller.popBackStack()
                }
            ) {
                Icon(
                    tint = LightBlue,
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
        }

    )
}