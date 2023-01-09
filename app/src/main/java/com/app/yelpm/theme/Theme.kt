package com.app.yelpm.theme

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable

@ExperimentalMaterialApi
@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        typography = QuickSandTypography,
        content = content
    )
}
