package com.app.yelpm.presentation.ui.homepage.bottomsheet

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.app.yelpm.presentation.components.CountriesList
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
import com.app.yelpm.presentation.ui.homepage.HomePageViewType
import com.app.yelpm.presentation.ui.homepage.businesslist.BusinessList
import com.app.yelpm.presentation.ui.homepage.businesslist.FilterOptions
import com.app.yelpm.presentation.ui.homepage.map.MapScreen
import com.app.yelpm.presentation.ui.homepage.map.MapViewModel
import com.app.yelpm.presentation.ui.homepage.toolbar.CardToolbar


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomSheetDrawer(homepageViewModel: HomePageViewModel, mapViewModel: MapViewModel) {
    val bottomSheetState = rememberBottomSheetState(
        initialValue = BottomSheetValue.Collapsed,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing
        )
    )
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = bottomSheetState
    )
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetGesturesEnabled = homepageViewModel.currentView.value != HomePageViewType.COUNTRIES_SELECTOR,
        drawerGesturesEnabled = homepageViewModel.currentView.value != HomePageViewType.COUNTRIES_SELECTOR,
        sheetContent = {
            if(homepageViewModel.currentView.value == HomePageViewType.HOMEPAGE) {
                AnimatedVisibility(visible = homepageViewModel.currentView.value == HomePageViewType.HOMEPAGE) {
                    BottomSheet(homepageViewModel = homepageViewModel)
                }
            } else if(homepageViewModel.currentView.value == HomePageViewType.COUNTRIES_SELECTOR) {
                AnimatedVisibility(visible = homepageViewModel.currentView.value == HomePageViewType.COUNTRIES_SELECTOR) {
                    CountriesList(
                        countries = homepageViewModel.countries.value,
                        homepageViewModel = homepageViewModel,
                        bottomSheetState = bottomSheetScaffoldState.bottomSheetState
                    )
                }
            }
        },
        sheetElevation = 8.dp,
        backgroundColor = Color.Transparent,
        contentColor = Color.Transparent,
        sheetShape = RoundedCornerShape(
            topStart = if(!bottomSheetState.isExpanded) 20.dp else 0.dp,
            topEnd = if(!bottomSheetState.isExpanded) 20.dp else 0.dp),
        sheetPeekHeight = 250.dp,
        sheetBackgroundColor = MaterialTheme.colors.surface
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp)) {
            MapScreen(viewModel = mapViewModel)
            CardToolbar(bottomSheetScaffoldState.bottomSheetState, homePageViewModel = homepageViewModel)
        }
    }

}