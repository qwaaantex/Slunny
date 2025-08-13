package com.example.slunny.Screens.Widgets.LikelyTowns

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LikelyTownsSearch() {
    var query by remember {
        mutableStateOf<String>("")
    }
    var expanded by remember {
        mutableStateOf<Boolean>(false)
    }
    val searchBarShape = RoundedCornerShape(16.dp)
    SearchBar(
        modifier = Modifier
            .padding(10.dp)
            .clip(searchBarShape),
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = Color.LightGray
            )
        },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Color.LightGray
            )
        },
        placeholder = {
            Text(
                text = "Напишите город...",
                style = TextStyle(color = Color.LightGray, fontSize = 16.sp)
            )
        },
        colors = SearchBarDefaults.colors(
            dividerColor = Color.Transparent
        ),
        shape = searchBarShape,
        query = query,
        onQueryChange = {
            query = it
        },
        onSearch = { expanded = false },
        active = expanded,
        onActiveChange = { expanded = it }
    ) {
        Text("Лол")
    }
}