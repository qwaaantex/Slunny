package com.example.slunny.Data.Location

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.util.Locale

class FetchLocation() : ViewModel() {

    var city: String? by mutableStateOf(null)
    var isPermissionGranted by mutableStateOf(true)

    suspend fun getCity(context: Context) {
        try {
            if (ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                isPermissionGranted = false
                Log.d("MyLog", "Ошибка получения разрешения!")
            }
            var loc = getLocationFused(context)
            loc?.let {
               val geocoder = Geocoder(context, Locale.getDefault())
                val citys = geocoder.getFromLocation(it.latitude, it.longitude, 1)
                city = citys?.firstOrNull()?.let {
                    adress -> adress.locality ?: adress.adminArea ?: adress.subLocality
                }
            }
        } catch (e: Exception) {
            Log.d("MyLog", e.toString())
        }
    }


    @RequiresPermission(allOf = [Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION])
    private suspend fun getLocationFused(context: Context) =
        LocationServices.getFusedLocationProviderClient(context).lastLocation.await()
}