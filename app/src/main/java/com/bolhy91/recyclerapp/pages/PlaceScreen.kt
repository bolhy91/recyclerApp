package com.bolhy91.recyclerapp.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun PlaceScreen() {
    val city = LatLng(9.0817275, -79.5932217)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(city, 10f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(), cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = city),
            title = "Ciudad de Panama",
            snippet = "Marker in Panama"
        )
    }
}