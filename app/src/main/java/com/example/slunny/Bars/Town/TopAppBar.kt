package com.example.slunny.Bars.Town

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.slunny.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TownTopAppBar(navController: NavController) {
    TopAppBar(
        title =  {},
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