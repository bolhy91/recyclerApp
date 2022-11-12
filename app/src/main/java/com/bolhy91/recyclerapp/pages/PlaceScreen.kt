package com.bolhy91.recyclerapp.pages

import android.location.Location
import android.util.Log
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
    val city = LatLng(9.0182406, -79.5045156)

    val myLocation = Location("Mi Casa")
    myLocation.latitude = 8.9984378
    myLocation.longitude = -79.5227452

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(city, 12f)
    }
    val state = viewModel.state.value
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(mapType = MapType.NORMAL)
    ) {
        if (state.places.isNotEmpty()) {
            state.places.forEach { place ->
                val valor = Location("")
                valor.latitude = place.latitude.toDouble()
                valor.longitude = place.longitude.toDouble()
                val distance = (myLocation.distanceTo(valor)/1000)
                Log.i("DISTANCE: ${place.name}", (distance/1000).toString())
                if (distance <= 5) {
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
}