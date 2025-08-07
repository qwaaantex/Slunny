package com.example.slunny.Screens.Widgets.Home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarColors
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstrainedLayoutReference
import androidx.constraintlayout.compose.ConstraintLayoutScope
import com.example.slunny.Constants.Lists
import com.example.slunny.R
import com.example.slunny.ui.theme.LightBlue
import com.example.slunny.ui.theme.darkBlue

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearch(Text: String, Act: Boolean) {
    var searchText by remember {
        mutableStateOf(Text)
    }
    var active by remember {
        mutableStateOf(Act)
    }
    var list = remember {
        mutableStateOf<List<String>?>(emptyList())
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
        query = searchText,
        onQueryChange = {
            searchText = it; list.value = containsItems(Lists.Towns, searchText.lowercase())
        },
        onSearch = { active = false },
        active = active,
        onActiveChange = { active = it }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(16.dp)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (!list.value.isNullOrEmpty()) {
                items(list.value!!.size) {
                    list.value!!.forEach { item ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clip(RoundedCornerShape(8.dp)).padding(8.dp)
                                    .background(LightBlue),
                                horizontalArrangement = Arrangement.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    tint = darkBlue,
                                    contentDescription = null,
                                    painter = painterResource(R.drawable.baseline_location_city_24)
                                )
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    maxLines = 1,
                                    text = item,
                                    fontWeight = FontWeight.Bold,
                                    overflow = TextOverflow.Ellipsis,
                                    fontSize = 18.sp
                                )
                            }
                        }
                    }
                }
            } else {
                item {
                    Text(
                        "Не найдено", style = TextStyle
                            (color = Color.LightGray, fontSize = 16.sp)
                    )
                }
            }
        }
    }
}

fun containsItems(list: List<String>, search: String): List<String> {
    return list.filter {
        it.lowercase().startsWith(search)
    }
}