package com.app.yelpm.presentation.ui.homepage.map

import android.location.Location
import com.app.yelpm.presentation.ui.homepage.map.clusters.ZoneClusterItem


data class MapState(
    val lastKnownLocation: Location?,
    val clusterItems: List<ZoneClusterItem>,
)
