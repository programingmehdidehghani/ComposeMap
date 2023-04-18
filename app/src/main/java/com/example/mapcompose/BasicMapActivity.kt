package com.example.mapcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

private const val TAG = "BasicMapActivity"

val singapore = LatLng(1.35, 103.87)
val singapore1 = LatLng(1.40, 103.77)
val singapore2 = LatLng(1.45, 103.77)
val defaultCameraPosition = CameraPosition.fromLatLngZoom(singapore,11f)

class BasicMapActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            
        }
    }
}