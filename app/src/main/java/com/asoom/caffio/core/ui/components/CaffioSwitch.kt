package com.asoom.caffio.core.ui.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.asoom.caffio.core.designSystem.theme.CaffioTheme

@Composable
fun CaffioSwitch(
    modifier: Modifier = Modifier,
    selectedLevel: String,
    onLevelChanged: (String) -> Unit
) {
    var selected by remember { mutableStateOf(selectedLevel) }

    val options = listOf("Low", "Medium", "High")

    val transition = androidx.compose.animation.core.updateTransition(
        targetState = selected,
        label = "levelTransition"
    )

    Column(
        modifier = modifier
            .width(152.dp)
    ) {
        Box(
            modifier = Modifier
                .width(152.dp)
                .height(56.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFF5F5F5))
        ) {
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                options.forEach { option ->
                    val iconAlpha by transition.animateFloat(
                        transitionSpec = { tween(durationMillis = 1500) },
                        label = "IconAlpha-$option"
                    ) { targetSelected ->
                        if (option == targetSelected) 1f else 0f
                    }

                    Box(
                        Modifier
                            .fillMaxHeight()
                            .width(50.dp)
                            .clip(CircleShape)
                            .graphicsLayer { this.alpha = iconAlpha }
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }
                            ) {
                                if (option != selected) {
                                    selected = option
                                    onLevelChanged(option)
                                }
                            },
                        contentAlignment = Alignment.Center
                    ) {
                        SelectShape(isSize = false, isSelected = option == selected)
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            options.forEach {
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = CaffioTheme.colors.background.copy(alpha = 0.6f),
                        fontWeight = FontWeight.Medium
                    )
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview() {
    CaffioSwitch(
        selectedLevel = "Low",
        onLevelChanged = {}
    )
}