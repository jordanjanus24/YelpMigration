package com.app.yelpm.presentation.ui.homepage.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.app.yelpm.R

@Composable
fun CardToolbar(navController: NavController, route: String) {
    var showMenu by remember { mutableStateOf(false) }
    Surface(color = Color.Transparent) {
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CardToolbar(navController = rememberNavController(), route = "friendlist")
}