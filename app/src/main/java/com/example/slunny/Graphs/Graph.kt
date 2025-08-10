package com.example.slunny.Graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.slunny.Constants.Home
import com.example.slunny.Constants.Info
import com.example.slunny.Constants.TownData
import com.example.slunny.Screens.Home
import com.example.slunny.Screens.Town

@Composable
fun Graph(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Home,
    ) {
        composable<Home> {
            Home(navHostController)
        }
        composable<TownData> { entry ->
            val data: TownData = entry.toRoute<TownData>()
            Town(data, controller = navHostController)
        }
        composable<Info> {
            entry ->
            com.example.slunny.Screens.Info(navHostController)
        }
    }
}

