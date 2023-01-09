package com.app.yelpm.presentation.ui.homepage.map.clusters

import com.app.yelpm.domain.model.Coordinates
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.PolygonOptions
import com.google.maps.android.clustering.ClusterItem

data class ZoneClusterItem(
    val id: String,
    private val title: String,
    private val snippet: String,
    val coordinates: Coordinates
) : ClusterItem {

    override fun getSnippet() = snippet

    override fun getTitle() = title

    override fun getPosition() = LatLng(coordinates.latitude!!, coordinates.longitude!!)
}