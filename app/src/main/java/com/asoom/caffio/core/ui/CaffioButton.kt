package com.asoom.caffio.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews

@Composable
fun CaffioButton(
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CaffioTheme.colors.background,
    contentColor: Color = CaffioTheme.colors.textSecondary
) {
    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = CaffioTheme.shape.large
            )
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .wrapContentSize()
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            style = CaffioTheme.typography.labelLarge,
            modifier = Modifier.padding(end = 8.dp)
        )
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.size(28.dp)
        )
    }
}

@ThemePreviews
@Composable
fun PreviewCaffioButton() {
    CaffioTheme {
        CaffioButton(
            text = "bring my coffee",
            icon = R.drawable.icon_cup,
            onClick = {}
        )
    }
}
