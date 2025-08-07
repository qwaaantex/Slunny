package com.example.slunny.Data.Weather

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

const val key = "2f69ef0332ea402586975549253007"


class Weather(context: Context) : ViewModel() {
    private val request = Volley.newRequestQueue(context.applicationContext)

    var isLoading by mutableStateOf<Boolean>(false)
    var isLoadingList by mutableStateOf<Boolean>(false)

    var responseTemperature by mutableStateOf<FetchTemperature?>(null)
    var errorTemperature by mutableStateOf<String?>(null)
    var isLoadingTemperature by mutableStateOf<Boolean>(false)


    var responseData by mutableStateOf<FetchModel?>(null)
    var errorMessage by mutableStateOf<String?>(null)

    var responseMapData by mutableStateOf<FetchList?>(null)
    var errorMapMessage by mutableStateOf<String?>(null)


    fun getWeather(town: String) {
        isLoading = true
        errorMessage = null
        val url = "https://api.weatherapi.com/v1/current.json"
        val stringRequest = StringRequest(
            Request.Method.GET, "$url?key=$key&q=$town&aqi=no",
            { response ->
                try {
                    val Object = JSONObject(response)
                    val jsonObject = Object.getJSONObject("current")
                    val temp = jsonObject.getDouble("temp_c")
                    val windSpeed = jsonObject.getDouble("wind_mph")
                    val tempFeels = jsonObject.getDouble("feelslike_c")
                    val Humidity = jsonObject.getInt("humidity")
                    val Cloud = jsonObject.getInt("cloud")
                    val ImageUrlObj = jsonObject.getJSONObject("condition");
                    val ImageUrl = ImageUrlObj.getString("icon")
                    responseData =
                        FetchModel(
                            tempCurrent = temp,
                            tempFeels = tempFeels,
                            windSpeed = windSpeed,
                            Humidity = Humidity,
                            Cloud = Cloud,
                            ImageUrl = ImageUrl
                        )
                    isLoading = false
                } catch (e: Exception) {
                    errorMapMessage = e.toString()
                    Log.d("MyLog", e.toString())
                }
            },
            { error ->
                Log.d("MyLog", error.message.toString())
                errorMessage = error.message
            }
        )
        stringRequest.retryPolicy = DefaultRetryPolicy(
            60000,
            1,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        request.add(stringRequest)
    }

    fun getWeatherList(town: String) {
        isLoadingList = true
        errorMapMessage = null
        val url = "https://api.weatherapi.com/v1/forecast.json"
        val stringRequest = StringRequest(
            Request.Method.GET, "$url?key=$key&q=$town&days=3&aqi=no&alerts=no",
            { response ->
                try {
                    val Object = JSONObject(response);
                    val JsonObjDay = Object.getJSONObject("forecast").getJSONArray("forecastday")
                    var forecastMap = mutableMapOf<String, Double>()
                    var forecastInfo = mutableMapOf<Int, Double>()
                    var forecastCurious = mutableMapOf<Double, Double>()
                    for (i in 0 until JsonObjDay.length()) {
                        val current = JsonObjDay.getJSONObject(i).getJSONObject("day")
                        val date = JsonObjDay.getJSONObject(i).getString("date")
                        val humidity =
                            current.getInt("avghumidity")
                        val windSpeed = current
                            .getDouble("maxwind_mph")
                        val max_temp =
                            current.getDouble("maxtemp_c")
                        val avg_vis = current.getDouble("avgvis_km")
                        val totalprecip = current.getDouble("totalprecip_mm")
                        forecastMap.put(date, max_temp)
                        forecastInfo.put(humidity, windSpeed)
                        forecastCurious.put(totalprecip, avg_vis)
                    }
                    responseMapData = FetchList(
                        MapData = forecastMap,
                        MapInfo = forecastInfo,
                        MapCurious = forecastCurious
                    )
                    isLoadingList = false
                } catch (e: Exception) {
                    errorMapMessage = e.message
                    Log.d("MyLog", e.message.toString())
                }
            }, { error ->
                errorMapMessage = error.toString()
                Log.d("MyLog", error.toString())
            }
        )
        stringRequest.setRetryPolicy(
            DefaultRetryPolicy(
                60000,
                1,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )
        )
        request.add(stringRequest)
    }

    fun getWeatherTemperature(town: String) {
        isLoadingTemperature = true
        val url =
            "https://api.weatherapi.com/v1/forecast.json?key=$key&q=$town&days=1&aqi=no&alerts=no"
        val stringRequest = StringRequest(
            Request.Method.GET, url, { response ->
                try {
                    val obj = JSONObject(response)
                    val jsonObject = obj.getJSONObject("forecast").getJSONArray("forecastday")
                    for (i in 0 until jsonObject.length()) {
                        val tempObj = jsonObject.getJSONObject(i).getJSONObject("day")
                        val max_temp = tempObj.getDouble("maxtemp_c")
                        val min_temp = tempObj.getDouble("mintemp_c")
                        val humidity = tempObj.getInt("avghumidity")
                        val weather = tempObj.getJSONObject("condition").getString("text")
                        responseTemperature = FetchTemperature(
                            tempMax = max_temp,
                            tempMin = min_temp,
                            humidity = humidity,
                            weather
                        )
                    }
                    isLoadingTemperature = false
                } catch (e: Exception) {
                    errorTemperature = e.toString()
                    Log.d("MyLog", e.toString())
                    isLoadingTemperature = false
                }
            }, { error ->
                errorTemperature = error.toString()
                Log.d("MyLog", error.toString())
                isLoadingTemperature = false
            }
        )
        stringRequest.retryPolicy = DefaultRetryPolicy(
            60000,
            1,
            DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        )
        request.add(stringRequest)
    }
}