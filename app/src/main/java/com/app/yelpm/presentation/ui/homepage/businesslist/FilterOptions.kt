package com.app.yelpm.presentation.ui.homepage.businesslist

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FilterOptions(sortOptions: List<String>, currentFilter: State<String>, onClick: (String) -> Unit) {
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
                    onClick = { onClick(item) },
                    colors = ButtonDefaults.outlinedButtonColors(
                        backgroundColor = if(currentFilter.value == item) MaterialTheme.colors.primaryVariant else MaterialTheme.colors.surface,
                        contentColor = MaterialTheme.colors.onSurface
                    )
                ) {
                    Text(item, color = if(currentFilter.value == item) MaterialTheme.colors.onSurface else MaterialTheme.colors.onSurface)
                }
            }
        }

    }
}