package com.example.slunny.Screens.Widgets.Info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.example.slunny.R
import com.example.slunny.ui.theme.LightBlue

@Composable
fun InfoInformation() {
    Row(
        modifier = Modifier.fillMaxWidth(0.9f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            overflow = TextOverflow.Ellipsis,
            maxLines = 3,
            fontSize = 16.sp,
            modifier = Modifier.fillMaxWidth(0.8f),
            textAlign = TextAlign.Center,
            text = "Погода на века! Нажав на кнопку вы поддержите нас!"
        )
        IconButton(
            onClick = {}
        ) {
            Icon(
                tint = LightBlue,
                painter = painterResource(
                    R.drawable.baseline_add_reaction_24
                ),
                contentDescription = null
            )
        }
    }
}