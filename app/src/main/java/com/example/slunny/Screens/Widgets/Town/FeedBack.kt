package com.example.slunny.Screens.Widgets.Town

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@Composable
fun TownFeedBack(
) {
    var isExpanded = remember {
        mutableStateOf(false)
    }
    var status = remember {
        mutableStateOf("Не указано")
    }
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(0.2f),
                    text = status.value
                )
                Column {
                    IconButton(onClick = {
                        isExpanded.value = true
                    }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )
                    }
                    TownFeedBackMenu(
                        isExpanded = isExpanded.value,
                        onDismiss = {
                            isExpanded.value = false
                        },
                        statusChanged = { item ->
                            status.value = item
                            isExpanded.value = false
                        }
                    )
                }
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