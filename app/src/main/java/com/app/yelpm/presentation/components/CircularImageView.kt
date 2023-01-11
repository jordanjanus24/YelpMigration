package com.app.yelpm.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.app.yelpm.utils.GlideResponse

@Composable
fun CircularImageView(image: GlideResponse?) {
    Box(
        modifier = Modifier
            .padding(end = 8.dp)
            .requiredSize(50.dp)
    ) {
        Card(
            modifier = Modifier.matchParentSize().padding(),
            backgroundColor = Color.Transparent,
            contentColor = Color.Transparent,
            elevation = 5.dp,
            shape = CircleShape
        ) {
            image?.let { response ->
                response.bitmap?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        modifier = Modifier
                            .matchParentSize(),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Featured Image",
                    )
                }
            }
        }
    }
}