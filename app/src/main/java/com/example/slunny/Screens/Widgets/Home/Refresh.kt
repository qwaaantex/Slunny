package com.example.slunny.Screens.Widgets.Home


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.slunny.ui.theme.LightBlue

@Composable
fun HomeRefresh() {
    IconButton(
        colors = IconButtonColors(
            containerColor = LightBlue,
            contentColor = Color.Black,
            disabledContentColor = Color.Black,
            disabledContainerColor = LightBlue
        ),
        onClick = {
        }) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = null
        )
    }
}