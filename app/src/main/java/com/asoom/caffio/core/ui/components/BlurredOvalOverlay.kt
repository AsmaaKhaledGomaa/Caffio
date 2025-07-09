package com.asoom.caffio.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews
import kotlin.math.hypot

@Composable
fun BlurredOvalOverlay(
    modifier: Modifier = Modifier,
    width: Dp = 177.31.dp,
    height: Dp = 27.65.dp,
    backgroundColor: Color = CaffioTheme.colors.background
) {
    Box(
        modifier = modifier
            .width(width)
            .height(height)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .drawBehind {
                    val center = Offset(size.width / 2f, size.height / 2f)
                    val radius = hypot(size.width, size.height)

                    drawOval(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                backgroundColor.copy(alpha = 0.9f),
                                backgroundColor.copy(alpha = 0.1f)
                            ),
                            center = center,
                            radius = radius
                        ),
                        size = Size(size.width, size.height)
                    )
                }
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.92f))
                .blur(1000.dp)
        )
    }
}

@ThemePreviews
@Composable
fun BlurredOvalOverlayPreview() {
    BlurredOvalOverlay()
}

