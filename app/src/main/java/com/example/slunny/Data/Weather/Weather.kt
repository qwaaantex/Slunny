package com.example.slunny.Data.Weather

import android.content.Context
import android.util.Log
import com.android.volley.DefaultRetryPolicy
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.flow.MutableStateFlow
import org.json.JSONObject

const val key = "2f69ef0332ea402586975549253007"


class Weather(context: Context) {
    private val request = Volley.newRequestQueue(context.applicationContext)

    var isLoading = MutableStateFlow<Boolean>(false)
    var isLoadingList = MutableStateFlow<Boolean>(false)


    var responseData = MutableStateFlow<FetchModel?>(null)
    var errorMessage = MutableStateFlow<String?>(null)

    var responseMapData = MutableStateFlow<FetchList?>(null)
    var errorMapMessage = MutableStateFlow<String?>(null)


    fun getWeather(town: String) {
        isLoading.value = true

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
                    responseData.value =
                        FetchModel(
                            tempCurrent = temp,
                            tempFeels = tempFeels,
                            windSpeed = windSpeed,
                            Humidity = Humidity,
                            Cloud = Cloud,
                            ImageUrl = ImageUrl
                        )
                    isLoading.value = false
                } catch (e: Exception) {
                    Log.d("MyLog", e.toString())
                }
            },
            { error ->
                Log.d("MyLog", error.message.toString())
                errorMessage.value = error.message
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
        isLoadingList.value = true

        val url = "https://api.weatherapi.com/v1/forecast.json"
        val stringRequest = StringRequest(
            Request.Method.GET, "$url?key=$key&q=$town&days=3&aqi=no&alerts=no",
            { response ->
                try {
                    val Object = JSONObject(response);
                    val JsonObjDay = Object.getJSONObject("forecast").getJSONArray("forecastday")
                    var forecastMap = mutableMapOf<String, Double>()
                    var forecastInfo = mutableMapOf<Int, Double>()
                    for (i in 0 until JsonObjDay.length()) {
                        val date = JsonObjDay.getJSONObject(i).getString("date")
                        val humidity =
                            JsonObjDay.getJSONObject(i).getJSONObject("day").getInt("avghumidity")
                        val windSpeed = JsonObjDay.getJSONObject(i).getJSONObject("day").getDouble("maxwind_mph")
                        val max_temp =
                            JsonObjDay.getJSONObject(i).getJSONObject("day").getDouble("maxtemp_c")
                        forecastMap.put(date, max_temp)
                        forecastInfo.put(humidity, windSpeed)
                    }
                    responseMapData.value = FetchList(MapData = forecastMap, MapInfo = forecastInfo)
                    Log.d("MyLog", responseMapData.value.toString())
                    isLoadingList.value = false
                } catch (e: Exception) {
                    errorMapMessage.value = e.message
                    Log.d("MyLog", e.message.toString())
                }
            }, { error ->
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

}