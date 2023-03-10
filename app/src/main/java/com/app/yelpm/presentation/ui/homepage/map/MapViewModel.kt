package com.app.yelpm.presentation.ui.homepage.map

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.yelpm.domain.model.Business
import com.app.yelpm.presentation.ui.homepage.map.clusters.ZoneClusterItem
import com.app.yelpm.presentation.ui.homepage.map.clusters.ZoneClusterManager
import com.app.yelpm.presentation.ui.homepage.map.clusters.calculateCameraViewPoints
import com.app.yelpm.presentation.ui.homepage.map.clusters.getCenterOfPolygon
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.clustering.ClusterManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(): ViewModel() {

    val state: MutableState<MapState> = mutableStateOf(
        MapState(
            lastKnownLocation = null,
            clusterItems = listOf())
    )
    @SuppressLint("MissingPermission")
    fun getDeviceLocation(
        fusedLocationProviderClient: FusedLocationProviderClient
    ) {
        try {
            val locationResult = fusedLocationProviderClient.lastLocation
            locationResult.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    state.value = state.value.copy(
                        lastKnownLocation = task.result,
                    )
                }
            }
        } catch (_: SecurityException) {
        }
    }
    fun setupClusterManager(
        context: Context,
        map: GoogleMap,
    ): ZoneClusterManager {
        val clusterManager = ZoneClusterManager(context, map)
        clusterManager.clearItems()
        clusterManager.addItems(state.value.clusterItems)
        Log.d("STATE", state.value.clusterItems.toString())
        return clusterManager
    }

    fun calculateZoneLatLngBounds(): LatLngBounds {
        val latLngs = state.value.clusterItems.map { it.coordinates }
            .map { LatLng(it.latitude!!, it.longitude!!) }
        return latLngs.calculateCameraViewPoints().getCenterOfPolygon()
    }
    fun setClusterItems(business: List<Business>) {
        viewModelScope.launch {
            val clusterItems = business.map { business ->
                ZoneClusterItem(
                    id = business.id!!,
                    title = business.name!!,
                    snippet = "${business.location?.getDisplayAddress()}",
                    coordinates = business.coordinates!!
                )
            }
            val mapState = state.value
            state.value = MapState(
                lastKnownLocation = mapState.lastKnownLocation,
                clusterItems = clusterItems
            )
        }
    }

}