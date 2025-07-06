package com.asoom.caffio.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import com.asoom.caffio.core.designSystem.CaffioShape
import com.asoom.caffio.core.designSystem.CaffioTypography
import com.asoom.caffio.core.designSystem.colors.CaffioColors
import com.asoom.caffio.core.designSystem.colors.LocalCaffioColors
import com.asoom.caffio.core.designSystem.colors.createColorScheme

@Composable
fun CaffioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) CaffioColors.dark() else CaffioColors.light()
    val colorScheme = createColorScheme(colors)

    CompositionLocalProvider(LocalCaffioColors provides colors) {
        CaffioTheme(
            colorScheme = colorScheme,
            typography = CaffioTypography,
            shapes = CaffioShape,
            content = content
        )
    }
}

object CaffioTheme {
    val colors: CaffioColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCaffioColors.current ?: if (isSystemInDarkTheme()) {
            CaffioColors.dark()
        } else {
            CaffioColors.light()
        }

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = CaffioTypography

    val shape: Shapes
        @Composable
        @ReadOnlyComposable
        get() = CaffioShape
}
