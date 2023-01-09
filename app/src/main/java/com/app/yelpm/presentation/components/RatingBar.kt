package com.app.yelpm.presentation.components

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(rating: Float) {
    LazyRow(verticalAlignment = Alignment.CenterVertically) {
        items(5) { index ->
            val isEnabled = index <= rating - 1
            Icon(
                imageVector = Icons.Filled.Star,
                contentDescription = "Star",
                tint = if(isEnabled) Color.Blue else Color.LightGray,
                modifier = Modifier
                    .requiredSize(15.dp)
            )
        }
    }
}