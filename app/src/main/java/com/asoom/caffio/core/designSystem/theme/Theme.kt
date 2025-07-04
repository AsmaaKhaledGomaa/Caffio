package com.asoom.caffio.core.designSystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.asoom.caffio.core.designSystem.CaffioShapes
import com.asoom.caffio.core.designSystem.CaffioTypography
import com.asoom.caffio.core.designSystem.caffioColorScheme

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
