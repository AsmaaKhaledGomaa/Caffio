package com.asoom.caffio.core.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews

@Composable
fun CaffioButton(
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CaffioTheme.colors.surface,
    contentColor: Color = CaffioTheme.colors.textPrimary
) {
    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50)
            )
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            modifier = Modifier.clickable(onClick = onClick)
        )
        Spacer(modifier = Modifier.size(12.dp))
        IconButton(
            onClick = onClick,
            modifier = Modifier.size(28.dp)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = contentColor
            )
        }
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
