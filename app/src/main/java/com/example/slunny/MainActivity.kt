package com.example.slunny

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.slunny.Graphs.Graph
import com.example.slunny.ui.theme.SlunnyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SlunnyTheme {
                val navHostController = rememberNavController()
                Graph(navHostController)
            }
        }

    }
}