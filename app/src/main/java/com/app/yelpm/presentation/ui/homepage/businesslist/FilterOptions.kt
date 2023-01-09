package com.app.yelpm.presentation.ui.homepage.businesslist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
        Spacer(modifier = Modifier.width(20.dp))
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(sortOptions) { item ->
                OutlinedButton(
                    onClick = {}, colors = ButtonDefaults.outlinedButtonColors(contentColor = MaterialTheme.colors.onSurface)
                ) {
                    Text(item, color = MaterialTheme.colors.onSurface)
                }
            }
        }

    }
}