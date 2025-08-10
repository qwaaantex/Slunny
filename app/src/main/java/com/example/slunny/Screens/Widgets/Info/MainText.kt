package com.example.slunny.Screens.Widgets.Info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        Text(text = VersionApp.version,
            style = TextStyle(
                fontSize = 20.sp
            ))
    }
}
