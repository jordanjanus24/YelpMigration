package com.app.yelpm.presentation.ui.homepage.toolbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.app.yelpm.R
import com.app.yelpm.presentation.ui.homepage.HomePageViewModel
import com.app.yelpm.presentation.ui.homepage.HomePageViewType
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardToolbar(bottomSheetState: BottomSheetState, homePageViewModel: HomePageViewModel) {
    // NOTE: Dropdown Menu
    // var showMenu by remember { mutableStateOf(false) }
    val animatedColor = animateColorAsState(
        if(bottomSheetState.isCollapsed && !bottomSheetState.isAnimationRunning) Color.Transparent else MaterialTheme.colors.primary,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing
        )
    )
    var text by remember { mutableStateOf(homePageViewModel.currentQuery.value) }
    val coroutineScope = rememberCoroutineScope()
    Surface(
        modifier = Modifier.fillMaxHeight(0.13f),
        color = if(bottomSheetState.isCollapsed) Color.Transparent else animatedColor.value
    ) {
        Column(modifier = Modifier.padding(all = 20.dp)) {
            Spacer(modifier = Modifier.requiredHeight(10.dp))
            Card(
                backgroundColor = MaterialTheme.colors.surface,
                elevation = 8.dp,
                contentColor = MaterialTheme.colors.surface,
                shape = RoundedCornerShape(5.dp)
            ) {
                TopAppBar(
                    title = {
                        if(homePageViewModel.currentView.value === HomePageViewType.SEARCH) {
                            BasicTextField(
                                value = text,
                                onValueChange = { newText ->
                                    homePageViewModel.filter(query = newText)
                                    text = newText
                                },
                                singleLine = true,
                                decorationBox = { innerTextField ->
                                    Row(
                                        Modifier
                                            .padding(16.dp)
                                    ) {
                                        Box {
                                            if(text.isEmpty()) {
                                                Text("Search")
                                            } else {
                                                Text(text)
                                                innerTextField()
                                            }

                                        }
                                    }
                                },
                            )
                        } else {
                            Text(text =
                            if(homePageViewModel.currentView.value === HomePageViewType.COUNTRIES_SELECTOR)
                                "Select Country"
                            else homePageViewModel.currentCountry.value,
                                style = MaterialTheme.typography.subtitle2,
                                color = MaterialTheme.colors.onSurface)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            if(homePageViewModel.currentView.value === HomePageViewType.COUNTRIES_SELECTOR ||
                                homePageViewModel.currentView.value === HomePageViewType.SEARCH) {
                                coroutineScope.launch {
                                    bottomSheetState.collapse()
                                    homePageViewModel.changeView(HomePageViewType.HOMEPAGE)
                                }
                            } else {
                                if(bottomSheetState.isExpanded) {
                                    coroutineScope.launch {
                                        bottomSheetState.collapse()
                                    }
                                }
                            }

                        }, enabled = bottomSheetState.isExpanded) {
                            if(bottomSheetState.isExpanded) {
                                Icon(
                                    imageVector = Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = MaterialTheme.colors.onSurface
                                )
                            } else {
                                Image(painter = painterResource(R.drawable.ic_logo),
                                    contentDescription = "Logo",
                                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                                )
                            }

                        }
                    },
                    actions = {
                        if (homePageViewModel.currentView.value === HomePageViewType.HOMEPAGE) {
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    homePageViewModel.changeView(HomePageViewType.COUNTRIES_SELECTOR)
                                    bottomSheetState.expand()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Place,
                                    contentDescription = "Select Country",
                                    tint = MaterialTheme.colors.onSurface
                                )
                            }
                            IconButton(onClick = {
                                coroutineScope.launch {
                                    homePageViewModel.changeView(HomePageViewType.SEARCH)
                                    bottomSheetState.expand()
                                }
                            }) {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = "Search",
                                    tint = MaterialTheme.colors.onSurface
                                )
                            }
                        }
                        // NOTE: Dropdown Menu
                        /*
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(imageVector = Icons.Default.MoreVert,
                                contentDescription = "More",
                                tint = MaterialTheme.colors.onSurface)
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(onClick = { }) {
                                Text("Search")
                            }
                            DropdownMenuItem(onClick = { }) {
                                Text("Settings")
                            }
                        }*/
                    },
                    backgroundColor = MaterialTheme.colors.surface
                )
            }
        }
    }

}