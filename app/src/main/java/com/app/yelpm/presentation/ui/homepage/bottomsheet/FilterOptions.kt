package com.app.yelpm.presentation.ui.homepage.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterOptions(vararg sortOptions: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Sort By", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.width(10.dp))
        LazyRow {
            items(sortOptions) { item ->
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(3.dp)
                        .background(Color.White)
                ) {
                    Text(item)
                }
            }
        }

    }
}