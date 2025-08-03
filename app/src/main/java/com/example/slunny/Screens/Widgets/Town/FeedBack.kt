package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@Composable
fun TownFeedBack(
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .clip(RoundedCornerShape(16.dp))
            .background(LightBlue)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(0.9f)
        ) {
            Text(
                "Ваше мнение",
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null
                )
            }
        }
    }
    Text(
        "Оно поможет другим выбрать одежду или скорректировать прогноз",
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Gray
        ),
        modifier = Modifier.padding(8.dp),
        textAlign = TextAlign.Center
    )
}