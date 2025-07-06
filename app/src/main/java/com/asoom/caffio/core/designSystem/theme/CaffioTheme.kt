package com.asoom.caffio.core.designSystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.asoom.caffio.core.designSystem.CaffioShape
import com.asoom.caffio.core.designSystem.CaffioTypography


@Composable
fun CaffioTheme(
    colorScheme: androidx.compose.material3.ColorScheme,
    typography: androidx.compose.material3.Typography = CaffioTypography,
    shapes: androidx.compose.material3.Shapes = CaffioShape,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
