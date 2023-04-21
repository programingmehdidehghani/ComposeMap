package com.example.mapcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.CameraMoveStartedReason
import com.google.maps.android.compose.CameraPositionState
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class GoogleMapViewTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val startingZoom = 10f
    private val startingPosition = LatLng(1.23, 4.56)
    private lateinit var cameraPositionState: CameraPositionState

    private fun initMap(content: @Composable () -> Unit = {}){

        val countDownLatch = CountDownLatch(1)
        composeTestRule.setContent {
            GoogleMapView(
                modifier = Modifier.fillMaxSize(),
                cameraPositionState = cameraPositionState,
                onMapLoad = {
                    countDownLatch.countDown()
                }
            ){
                content.invoke()
            }
        }
        val mapLoaded = countDownLatch.await(30, TimeUnit.SECONDS)
        assertTrue("Map loaded",mapLoaded)
    }

    @Before
    fun setUp(){
        cameraPositionState = CameraPositionState(
            position = CameraPosition.fromLatLngZoom(
                startingPosition,
                startingZoom
            )
        )
    }

    @Test
    fun testStartingCameraPosition(){
        initMap()
        assertEquals(CameraMoveStartedReason.NO_MOVEMENT_YET,cameraPositionState.cameraMoveStartedReason)
        zoom(

        )
    }

    private fun zoom(
        shouldAnimate: Boolean,
        zoomIn: Boolean,
        assertionBlock: () -> Unit
    ){
        if (!shouldAnimate){
            composeTestRule.onNodeWithTag("cameraAnimations")
                .assertIsDisplayed()
                .performClick()
        }
        composeTestRule
    }
}