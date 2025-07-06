package com.asoom.caffio.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaffioTopAppBar(
    modifier: Modifier = Modifier,
    title: String? = null,
    backgroundColor: Color = CaffioTheme.colors.surface,
    actionButton: (@Composable (() -> Unit))? = null,
    navigationButton: (@Composable (() -> Unit))? = null
) {
    TopAppBar(
        modifier = modifier.fillMaxWidth(),
        title = {
            title?.let {
                Text(
                    text = it,
                    style = CaffioTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        },
        navigationIcon = {
            navigationButton?.invoke()
        },
        actions = {
            actionButton?.invoke()
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor
        )
    )
}

@ThemePreviews
@Composable
fun CaffioTopAppBarTitlePreview() {
    CaffioTheme {
        CaffioTopAppBar(
            title = "Caffio",
            navigationButton = {
                ActionButton(
                    onClick = {},
                    actionIcon = R.drawable.icon_back,
                )
            }
        )
    }
}

@Preview
@Composable
fun CaffioTopAppBarAccountPreview() {
    CaffioTheme {
        CaffioTopAppBar(
            navigationButton = {
                Image(
                    painter = painterResource(id = R.drawable.account),
                    contentDescription = "Account Icon",
                    modifier = Modifier.size(48.dp)
                )
            },
            actionButton = {
                ActionButton(
                    onClick = {},
                    actionIcon = R.drawable.icon_add,
                )
            }
        )
    }
}

@Preview
@Composable
fun CaffioTopAppBarCancelPreview() {
    CaffioTheme {
        CaffioTopAppBar(
            navigationButton = {
                ActionButton(
                    onClick = {},
                    actionIcon = R.drawable.icon_cancel
                )
            }
        )
    }
}
