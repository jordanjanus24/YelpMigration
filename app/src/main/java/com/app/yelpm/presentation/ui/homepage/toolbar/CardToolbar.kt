package com.app.yelpm.presentation.ui.homepage.toolbar

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Place
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.app.yelpm.R

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardToolbar(bottomSheetState: BottomSheetState) {
    var showMenu by remember { mutableStateOf(false) }
    val animatedColor = animateColorAsState(
        if(bottomSheetState.isCollapsed && !bottomSheetState.isAnimationRunning) Color.Transparent else Color.Red,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 0,
            easing = FastOutLinearInEasing
        )
    )
    Surface(
        modifier = Modifier.fillMaxHeight(0.15f),
        color = if(bottomSheetState.isCollapsed) Color.Transparent else animatedColor.value
    ) {
        Column(modifier = Modifier.padding(all = 20.dp)) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Card(
                backgroundColor = Color(0xFFBDFCBB).compositeOver(Color.White),
                elevation = 8.dp,
                contentColor = Color.White,
                shape = RoundedCornerShape(5.dp)
            ) {
                TopAppBar(
                    title = {
                        Text(text = "Select Country",
                            style = MaterialTheme.typography.subtitle2)
                    },
                    navigationIcon = {
                        IconButton(onClick = {}, enabled = false) {
                            Image(painter = painterResource(R.drawable.ic_logo),
                                contentDescription = "Logo"
                            )
                        }

                    },
                    actions = {
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Place,
                                contentDescription = "Select Country"
                            )
                        }
                        IconButton(onClick = { showMenu = !showMenu }) {
                            Icon(imageVector = Icons.Default.MoreVert,
                                contentDescription = "More")
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
                    backgroundColor = Color.White
                )
            }
        }
    }

}