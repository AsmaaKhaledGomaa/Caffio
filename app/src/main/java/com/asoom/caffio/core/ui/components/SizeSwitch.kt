package com.asoom.caffio.core.ui.components

import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SizeSwitch(
    selectedSize: CupSize,
    onSizeSelected: (CupSize) -> Unit,
    modifier: Modifier = Modifier
) {
    var selected by remember { mutableStateOf(selectedSize) }

    val options = listOf(CupSize.Small, CupSize.Medium, CupSize.Large)

    val transition = updateTransition(targetState = selected, label = "sizeTransition")

    val offsetX by transition.animateDp(
        transitionSpec = { tween(durationMillis = 400) },
        label = "OffsetX"
    ) { sel ->
        when (sel.label) {
            "S" -> 10.dp
            "M" -> 55.dp
            "L" -> 105.dp
            else -> 0.dp
        }
    }

    Box(
        modifier = modifier
            .width(152.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(100.dp))
            .background(Color(0xFFF5F5F5))
    ) {
        Row(
            Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            options.forEach { size ->
                Box(
                    Modifier
                        .fillMaxHeight()
                        .width(50.dp)
                        .clip(CircleShape)
                        .clickable(
                            indication = null,
                            interactionSource = remember { MutableInteractionSource() }
                        ) {
                            if (size != selected) {
                                selected = size
                                onSizeSelected(size)
                            }
                        },
                    contentAlignment = Alignment.Center
                ) {
                    val iconAlpha by transition.animateFloat(
                        transitionSpec = { tween(durationMillis = 2500) },
                        label = "IconAlpha-$size"
                    ) { targetSelected ->
                        if (size == targetSelected) 1f else 0f
                    }
                    if (iconAlpha > 0f) {
                        Box(
                            Modifier.graphicsLayer { this.alpha = iconAlpha }
                        ) {
                            SelectShape(isSize = true, text = size.label, isSelected = true)
                        }
                    } else {
                        Text(
                            text = size.label,
                            color = Color(0xFF666666),
                            style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        )
                    }
                }
            }
        }
    }
}

enum class CupSize(val label: String) {
    Small("S"),
    Medium("M"),
    Large("L");

    companion object {
        fun fromLabel(label: String): CupSize =
            when (label) {
                "S" -> Small
                "M" -> Medium
                "L" -> Large
                else -> Medium
            }
    }
}

@Preview
@Composable
private fun Preview() {
    SizeSwitch(
        selectedSize = CupSize.Medium,
        onSizeSelected = {},
        modifier = Modifier
            .padding(vertical = 16.dp)
    )
}