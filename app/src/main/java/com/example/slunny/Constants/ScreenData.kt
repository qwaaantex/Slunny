package com.example.slunny.Constants

import kotlinx.serialization.Serializable

@Serializable
data class TownData(
    val Name: String,
    val Temp: Int
)