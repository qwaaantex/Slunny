package com.example.slunny.Screens.Widgets.Info

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.Constants.VersionApp
import com.example.slunny.R
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@Composable
fun InfoMainText(name: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            tint = darkBlue,
            modifier = Modifier.size(40.dp),
            painter = painterResource(
                R.drawable.baseline_wb_sunny_24
            ),
            contentDescription = null
        )
        Text(
            name,
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = LightBlue
            )
        )
        Spacer(
            modifier = Modifier.fillMaxHeight(0.05f)
        )
        Card(
            colors = CardDefaults.cardColors(
                containerColor = Color.Green
            ),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp),
                ) {
                Text(
                    text = VersionApp.version,
                    style = TextStyle(
                        fontSize = 19.sp
                    ))
                Spacer(
                    modifier = Modifier.fillMaxHeight(0.05f)
                )
                Text(
                    text = "Beta",
                    style = TextStyle(
                        fontSize = 18.sp,
                    )
                )
            }
        }
    }
}
