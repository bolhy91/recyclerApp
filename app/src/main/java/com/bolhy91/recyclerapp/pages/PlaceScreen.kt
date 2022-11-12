package com.bolhy91.recyclerapp.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun PlaceScreen(
    viewModel: PlaceViewModel = hiltViewModel()
) {
    val city = LatLng(9.0817275, -79.5932217)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(city, 10f)
    }
    val state = viewModel.state.value
    GoogleMap(
        modifier = Modifier.fillMaxSize(), cameraPositionState = cameraPositionState,
        properties = MapProperties(mapType = MapType.NORMAL)
    ) {
        if (state.places.isNotEmpty()) {
            state.places.forEach { place ->
                Marker(
                    state = MarkerState(
                        position = LatLng(
                            place.latitude.toDouble(), place.longitude.toDouble()
                        )
                    ), title = place.name, snippet = place.description
                )
            }
        }
    }
}