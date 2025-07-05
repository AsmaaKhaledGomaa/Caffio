package com.asoom.caffio.core.designSystem.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CaffioColors(
    val primary: Color,
    val iconBackground: Color,
    val background: Color,
    val surface: Color,
    val textPrimary: Color,
    val textSecondary: Color,
    val accent: Color,
    val isLight: Boolean
) {
    companion object {
        fun light() = CaffioColors(
            primary = Color(0xFF7C351B),
            iconBackground = Color(0xFFF5F5F5),
            background = Color(0xFFFFEEE7),
            surface = Color(0xFFFFFFFF),
            textPrimary = Color(0xFF291710),
            textSecondary = Color(0xFF030004),
            accent = Color(0xDE1F1F1F),
            isLight = true
        )

        fun dark() = CaffioColors(
            primary = Color(0xFFD7A37F),
            iconBackground = Color(0xFF121212),
            background = Color(0xFF1E1E1E),
            surface = Color(0xFF000000),
            textPrimary = Color(0xFFF5F5F5),
            textSecondary = Color(0xFFB0B0B0),
            accent = Color(0xFFE6B89C),
            isLight = false
        )
    }
}

internal val LocalCaffioColors = staticCompositionLocalOf<CaffioColors> {
    error("No CaffioColors provided")
}