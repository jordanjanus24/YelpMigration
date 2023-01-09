package com.app.yelpm.presentation.ui.homepage.toolbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.yelpm.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardToolbar(bottomSheetState: BottomSheetState) {
    var showMenu by remember { mutableStateOf(false) }
    val animatedColor = animateColorAsState(
        if(bottomSheetState.isCollapsed && !bottomSheetState.isAnimationRunning) Color.Transparent else MaterialTheme.colors.primary,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing
        )
    )
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
                        Text(text = "Select Country",
                            style = MaterialTheme.typography.subtitle2,
                            color = MaterialTheme.colors.onSurface)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            if(bottomSheetState.isExpanded) {
                                coroutineScope.launch {
                                    bottomSheetState.collapse()
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
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = "Select Country",
                                tint = MaterialTheme.colors.onSurface
                            )
                        }
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
                        }
                    },
                    backgroundColor = MaterialTheme.colors.surface
                )
            }
        }
    }

}