package com.app.yelpm.presentation.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BoxScope.RoundedCornerImageView(img: Bitmap, padding: Dp) {
    Card(
        modifier = Modifier.matchParentSize(),
        backgroundColor = Color.Transparent,
        contentColor = Color.White,
        elevation = 1.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Image(
            bitmap = img.asImageBitmap(),
            modifier = Modifier
                .padding(padding)
                .matchParentSize(),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Featured Image",
        )
    }
}