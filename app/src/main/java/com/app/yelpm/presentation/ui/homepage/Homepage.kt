package com.app.yelpm.presentation.ui.homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.yelpm.presentation.ui.homepage.bottomsheet.BottomSheetDrawer
import com.app.yelpm.presentation.ui.homepage.map.MapScreen
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel
import com.app.yelpm.presentation.ui.homepage.toolbar.CardToolbar
import com.app.yelpm.theme.AppTheme

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
                    MapScreen(
                        state = mapViewModel.state.value,
                        mapViewModel::setupClusterManager,
                        calculateZoneViewCenter = mapViewModel::calculateZoneLatLngBounds)
                    Column {
                        CardToolbar(navController = navController, route = route)
                        BottomSheetDrawer(homepageViewModel = homepageViewModel)
                    }

                }
            }
        }
    }

}