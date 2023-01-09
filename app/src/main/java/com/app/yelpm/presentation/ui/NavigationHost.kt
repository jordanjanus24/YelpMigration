package com.app.yelpm.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.yelpm.presentation.ui.homepage.HomePageView
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel


@Composable
fun NavigationHost(navController: NavHostController,
                   mapViewModel: MapViewModel,
                   homepageViewModel: HomePageViewModel,
                   startDestination: String)
{
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = "homepage") {
            HomePageView(mapViewModel = mapViewModel, homepageViewModel = homepageViewModel)
        }
        composable(route = "details/{id}") {

        }
    }
    LaunchedEffect(key1 = Unit) {
        homepageViewModel.search("Philippines")
        homepageViewModel.currentBusiness.observeForever { businesses ->
            businesses?.let {
                mapViewModel.setClusterItems(it)
            }
        }
    }
}