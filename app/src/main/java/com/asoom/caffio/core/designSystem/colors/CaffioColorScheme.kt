package com.asoom.caffio.core.designSystem.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme

internal fun createColorScheme(colors: CaffioColors): ColorScheme {
    return if (colors.isLight) {
        lightColorScheme(
            primary = colors.primary,
            background = colors.background,
            surface = colors.surface,
            onPrimary = colors.textPrimary,
            onBackground = colors.textPrimary,
            onSurface = colors.textPrimary,
            secondary = colors.accent,
            onSecondary = colors.onSecondry,
            primaryContainer = colors.primaryContainer
        )
    } else {
        darkColorScheme(
            primary = colors.primary,
            background = colors.background,
            surface = colors.surface,
            onPrimary = colors.textPrimary,
            onBackground = colors.textPrimary,
            onSurface = colors.textPrimary,
            secondary = colors.accent,
            onSecondary = colors.onSecondry,
            primaryContainer = colors.primaryContainer
        )
    }
}