package com.example.slunny.Screens.Widgets.Town

import android.R
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.LightBlue

@Composable
fun TownFeedBackMenu(
    isExpanded: Boolean, onDismiss: () -> Unit,
    statusChanged: (String) -> Unit
) {
    val emoji = listOf<String>(
        "☀️",
        "🌡️",
        "🌈",
        "⛅️",
        "☔️",
        "🌧",
        "🌨️",
        "❄️",
        "⚡️",
    )
    DropdownMenu(
        shape = RoundedCornerShape(8.dp), expanded = isExpanded, onDismissRequest = {
            onDismiss()
        }) {
        Column {
            emoji.forEach { item ->
                Text(
                    text = item,
                    modifier = Modifier.padding(8.dp).clickable {
                        statusChanged(item)
                    },
                    fontSize = 20.sp,
                )
            }
        }
    }
}