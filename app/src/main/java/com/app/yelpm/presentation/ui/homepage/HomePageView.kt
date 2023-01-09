package com.app.yelpm.presentation.ui.homepage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.yelpm.presentation.ui.homepage.bottomsheet.BottomSheetDrawer
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel

@Composable
fun HomePageView(mapViewModel: MapViewModel, homepageViewModel: HomePageViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {
        BottomSheetDrawer(homepageViewModel = homepageViewModel, mapViewModel = mapViewModel)
    }
}