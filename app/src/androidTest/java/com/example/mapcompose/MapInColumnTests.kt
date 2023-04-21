package com.example.mapcompose

import androidx.compose.ui.test.junit4.createComposeRule
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraPositionState
import org.junit.Rule

class MapInColumnTests {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val startingZoom = 10f
    private val startingPosition = LatLng(1.23, 4.56)
    private lateinit var cameraPositionState: CameraPositionState

    private fun initMap()

}