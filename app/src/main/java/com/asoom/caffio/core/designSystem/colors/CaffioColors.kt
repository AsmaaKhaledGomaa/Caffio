package com.asoom.caffio.core.designSystem.colors

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CaffioColors(
    val primary: Color,
    val iconBackground: Color,
    val background: Color,
    val onBackground: Color,
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
            background = Color(0xFF1F1F1F),
            onBackground = Color(0x241F1F1F),
            surface = Color(0xFFFFFFFF),
            textPrimary = Color(0xDE1F1F1F),
            textSecondary = Color(0xDEFFFFFF),
            accent = Color(0xDE1F1F1F),
            isLight = true
        )

        fun dark() = CaffioColors(
            primary = Color(0xFF7C351B),
            iconBackground = Color(0xFF2A2A2A),
            background = Color(0xFF121212),
            onBackground = Color(0x14FFFFFF),
            surface = Color(0xFF1F1F1F),
            textPrimary = Color(0xDEFFFFFF),
            textSecondary = Color(0x99FFFFFF),
            accent = Color(0xFFFFFFFF),
            isLight = false
        )
    }
}

internal val LocalCaffioColors = staticCompositionLocalOf<CaffioColors?> { null }
