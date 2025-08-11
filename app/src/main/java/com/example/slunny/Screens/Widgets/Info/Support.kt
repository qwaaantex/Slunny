package com.example.slunny.Screens.Widgets.Info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.ui.theme.LightBlue

@Composable
fun InfoSupport() {
    val text = remember {
        mutableStateOf("")
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(0.9f),
            textAlign = TextAlign.Start,
            text =
                "Обратиться в поддержку",
            style = TextStyle(
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = LightBlue
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        TextField(
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.colors(
                disabledContainerColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                errorIndicatorColor = Color.Transparent
            ),
            modifier = Modifier.fillMaxWidth(0.9f),
            value = text.value,
            onValueChange = { t ->
                text.value = t
            },
            placeholder = {
                Text("Укажите ваше обращение...", color = Color.LightGray)
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = LightBlue
            ),
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.15f),
            onClick = {

            }
        ) {
            Text("Отправить")

        }
    }
}