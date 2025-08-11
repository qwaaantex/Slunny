package com.example.slunny.Screens.Widgets.Info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.R
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@Composable
fun InfoInformation() {
    Row(
        modifier = Modifier.fillMaxWidth(0.9f),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(0.8f),
            colors = CardDefaults.cardColors(
                containerColor = LightBlue
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                overflow = TextOverflow.Ellipsis,
                maxLines = 3,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth().padding(4.dp),
                textAlign = TextAlign.Center,
                text = "Это не простая погода, она наполнена нашими душами." +
                        " Нажав на кнопку, вы поддержите нас!"
            )
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = LightBlue
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            IconButton(
                onClick = {}
            ) {
                Icon(
                    tint = darkBlue,
                    painter = painterResource(
                        R.drawable.baseline_add_reaction_24
                    ),
                    contentDescription = null
                )
            }
        }
    }
}