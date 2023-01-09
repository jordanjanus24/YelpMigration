package com.app.yelpm.theme

import android.annotation.SuppressLint
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Primary = Color(0xFFC62828)
val PrimaryDark = Color(0xFFC62828)
val PrimaryVariant = Color(0xFFFFEEEE)

val Secondary = Color(0xFF2e7d32)
val SecondaryDark = Color(0xFF2e7d32)
val SecondaryVariant = Color(0xFFE2FDF3)


val Error = Color(0xFFB00020)
val OnSurface = Color(0xFF2D2E2F)


val LightThemeColors = lightColors(
    primary = Primary,
    primaryVariant = PrimaryVariant,
    onPrimary = Color.White,
    secondary = Secondary,
    secondaryVariant = SecondaryVariant,
    onSecondary = Color.White,
    error = Error,
    onError = Color.White,
    background = Color.White,
    onBackground = OnSurface,
    surface = Color.White,
    onSurface = OnSurface
)

 val DarkThemeColors = darkColors(
    primary = PrimaryDark,
    primaryVariant = PrimaryVariant,
    onPrimary = Color.White,
    secondary = SecondaryDark,
    onSecondary = Color.White,
    error = Error,
    onError = Color.White,
    background = Color.Black,
    onBackground = Color.White,
    surface = OnSurface,
    onSurface = Color.White,
)
