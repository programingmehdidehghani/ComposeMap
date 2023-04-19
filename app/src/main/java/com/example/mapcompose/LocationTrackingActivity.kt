package com.example.mapcompose

import android.location.Location
import androidx.activity.ComponentActivity
import com.google.android.gms.maps.LocationSource
import kotlin.random.Random

private const val TAG = "LocationTrackActivity"
private const val zoom = 8f

class LocationTrackingActivity: ComponentActivity() {

    private val locationSource =
}

private class MyLocationSource: LocationSource {

    private var listener: LocationSource.OnLocationChangedListener? = null

    override fun activate(listener: LocationSource.OnLocationChangedListener) {
        this.listener = listener
    }

    override fun deactivate() {
        listener = null
    }

    fun onLocationChanged(location: Location){
        listener?.onLocationChanged(location)
    }

}

private fun newLocation():Location {
    val location = Location("MyLocationProvider")
    location.apply {
        latitude = singapore.latitude + Random.nextFloat()
        longitude = singapore.longitude + Random.nextFloat()
    }
    return location
}