package com.app.yelpm.presentation.ui.homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.yelpm.presentation.ui.homepage.bottomsheet.BottomSheetDrawer
import com.app.yelpm.presentation.ui.homepage.map.MapScreen
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel
import com.app.yelpm.presentation.ui.homepage.toolbar.CardToolbar
import com.app.yelpm.theme.AppTheme
import com.google.android.gms.maps.model.LatLng

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Content(navController: NavHostController, mapViewModel: MapViewModel, homepageViewModel: HomepageViewModel) {
    val route by remember { mutableStateOf("") }
    AppTheme {
        NavHost(
            modifier = Modifier.fillMaxSize(),
            navController = navController,
            startDestination = "homepage"
        ) {
            composable(route = "homepage") {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MapScreen(viewModel = mapViewModel)
                    Column {
                        CardToolbar(navController = navController, route = route)
                        BottomSheetDrawer(homepageViewModel = homepageViewModel)
                    }
                }
            }
        }
        LaunchedEffect(key1 = Unit) {
            homepageViewModel.search("Philippines")
            homepageViewModel.currentBusiness.observeForever { businesses ->
                businesses?.let {
                    mapViewModel.setClusterItems(it)
                }
            }
            homepageViewModel.currentCenter.observeForever { center ->
                center?.let {
                    mapViewModel.setCenter(centerPoint = LatLng(it.latitude!!,it.longitude!!))
                }
            }
        }
    }

}