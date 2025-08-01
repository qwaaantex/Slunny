package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope

@Composable
fun TownInformation(
    info: String,
) {
    Text(
        modifier = Modifier.padding(4.dp),
        text = info,
        textAlign = TextAlign.Center
    )
}