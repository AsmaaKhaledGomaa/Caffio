package com.asoom.caffio.core.designSystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun CaffioTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = caffioColorScheme(darkTheme),
        typography = CaffioTypography,
        shapes = CaffioShapes,
        content = content
    )
}
