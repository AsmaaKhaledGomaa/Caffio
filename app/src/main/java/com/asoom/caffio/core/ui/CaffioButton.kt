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
import com.asoom.caffio.core.designSystem.CaffioDarkColors
import com.asoom.caffio.core.designSystem.theme.ThemePreviews

@Composable
fun CaffioButton(
    text: String,
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = CaffioDarkColors.Surface,
    contentColor: Color = CaffioDarkColors.TextPrimary
) {
    Row(
        modifier = modifier
            .background(
                color = backgroundColor,
                shape = RoundedCornerShape(50)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.size(12.dp))
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
    CaffioButton(
        text = "bring my coffee",
        icon = R.drawable.icon_cup,
        onClick = {}
    )
} 