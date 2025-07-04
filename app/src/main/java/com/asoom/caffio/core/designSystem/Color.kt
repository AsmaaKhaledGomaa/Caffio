package com.asoom.caffio.core.designSystem

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color


object CaffioLightColors {
    val Primary = Color(0xFF7C351B)
    val Background = Color(0xFFF5F5F5)
    val Surface = Color(0xFFFFEEE7)
    val TextPrimary = Color(0xFF291710)
    val TextSecondary = Color(0xFF030004)
    val Accent = Color(0xFF030004)
}

object CaffioDarkColors {
    val Primary = Color(0xFFD7A37F)
    val Background = Color(0xFF121212)
    val Surface = Color(0xFF1E1E1E)
    val TextPrimary = Color(0xFFF5F5F5)
    val TextSecondary = Color(0xFFB0B0B0)
    val Accent = Color(0xFFE6B89C)
}

fun caffioColorScheme(darkTheme: Boolean): ColorScheme {
    return if (darkTheme) {
        darkColorScheme(
            primary = CaffioDarkColors.Primary,
            background = CaffioDarkColors.Background,
            surface = CaffioDarkColors.Surface,
            onPrimary = CaffioDarkColors.TextPrimary,
            onBackground = CaffioDarkColors.TextPrimary,
            onSurface = CaffioDarkColors.TextPrimary,
            secondary = CaffioDarkColors.Accent
        )
    } else {
        lightColorScheme(
            primary = CaffioLightColors.Primary,
            background = CaffioLightColors.Background,
            surface = CaffioLightColors.Surface,
            onPrimary = CaffioLightColors.TextPrimary,
            onBackground = CaffioLightColors.TextPrimary,
            onSurface = CaffioLightColors.TextPrimary,
            secondary = CaffioLightColors.Accent
        )
    }
}
