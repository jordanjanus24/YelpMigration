package com.app.yelpm.presentation.ui.homepage.bottomsheet

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
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
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
        sheetGesturesEnabled = true,
        sheetContent = {
            Card(
                modifier = Modifier.fillMaxHeight(0.85f),
                elevation = 8.dp,
                backgroundColor = MaterialTheme.colors.surface) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Column {
                        val businesses = homepageViewModel.businesses.value
                        FilterOptions("Distance","Ratings","Reviews")
                        businesses?.let { it ->
                            BusinessList(businesses = it)
                        }
                    }
                }
            }

        },
        sheetElevation = 8.dp,
        backgroundColor = Color.Transparent,
        contentColor = Color.Transparent,
        sheetShape = RoundedCornerShape(
            topStart = if(!bottomSheetState.isExpanded) 20.dp else 0.dp,
            topEnd = if(!bottomSheetState.isExpanded) 20.dp else 0.dp),
        sheetPeekHeight = 200.dp
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            MapScreen(viewModel = mapViewModel)
            CardToolbar(bottomSheetScaffoldState.bottomSheetState)
        }
    }

}