package com.example.slunny.Bars.Town

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.slunny.R
import com.example.slunny.ui.theme.warningBlue

@Composable
fun TownInformationSnackBar(data: SnackbarData) {
    Snackbar(
        containerColor = warningBlue,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(0.9f),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                contentDescription = null,
                painter = painterResource(R.drawable.baseline_notifications_24)
            )
            Text(
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                text = data.visuals.message,
                modifier = Modifier.fillMaxWidth(0.7f),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )
            IconButton(onClick = {
                data.dismiss()
            }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null
                )
            }
        }
    }
}