package com.asoom.caffio.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews

@Composable
fun ActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    size: Dp = 48.dp,
    backgroundColor: Color = CaffioTheme.colors.iconBackground,
    @DrawableRes actionIcon: Int? = null,
    iconSize: Dp = 24.dp,
    iconColor: Color = CaffioTheme.colors.accent
) {
    if (actionIcon != null) {
        IconButton(
            onClick = onClick,
            modifier = modifier
                .size(size)
                .clip(shape),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = backgroundColor,
                contentColor = iconColor
            )
        ) {
            Icon(
                painter = painterResource(id = actionIcon),
                contentDescription = "Action Icon",
                modifier = Modifier.size(iconSize)
            )
        }
    }
}

@ThemePreviews
@Composable
fun ActionButtonPreview() {
    CaffioTheme {
        ActionButton(
            onClick = {},
            actionIcon = R.drawable.icon_add
        )
    }
}
