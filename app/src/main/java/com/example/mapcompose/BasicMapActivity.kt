package com.example.mapcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import com.google.maps.android.compose.DragState
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

private const val TAG = "BasicMapActivity"

val singapore = LatLng(1.35, 103.87)
val singapore2 = LatLng(1.40, 103.77)
val singapore3 = LatLng(1.45, 103.77)
val defaultCameraPosition = CameraPosition.fromLatLngZoom(singapore,11f)

class BasicMapActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isMapLoaded by remember { mutableStateOf(false) }

            val cameraPositionState = rememberCameraPositionState{
                position = defaultCameraPosition
            }

            Box(Modifier.fillMaxSize()){
                GoogleMapView(

                )
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun GoogleMapView(
    modifier: Modifier = Modifier,
    cameraPositionState: CameraPositionState = rememberCameraPositionState(),
    onMapLoad: () -> Unit = {},
    current: @Composable () -> Unit = {}
){
    val singaporeState = rememberMarkerState(position = singapore)
    val singapore2State = rememberMarkerState(position = singapore2)
    val singapore3State = rememberMarkerState(position = singapore3)
    var circleCenter by remember { mutableStateOf(singapore) }
    if (singaporeState.dragState == DragState.END){
        circleCenter = singaporeState.position
    }
}