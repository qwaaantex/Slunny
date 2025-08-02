package com.example.slunny.Data.Weather

import kotlinx.serialization.Serializable

@Serializable
data class FetchModel(
    val tempCurrent: Double,
    val tempFeels: Double,
    val windSpeed: Double,
    val Humidity: Int,
    val Cloud: Int,
    val ImageUrl: String
)

@Serializable
data class FetchList(
    val MapData: Map<String, Double>,
    val MapInfo: Map<Int, Double>
)