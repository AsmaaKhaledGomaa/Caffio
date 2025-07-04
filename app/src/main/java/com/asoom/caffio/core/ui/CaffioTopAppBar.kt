package com.asoom.caffio.core.ui

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun CaffioTopAppBar(
    title: String,
    navigationIcon: ImageVector,
    onNavigationClick: () -> Unit,
    actionIcon: ImageVector? = null,
    onActionClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(imageVector = navigationIcon, contentDescription = null)
            }
        },
        actions = {
            if (actionIcon != null && onActionClick != null) {
                IconButton(onClick = onActionClick) {
                    Icon(imageVector = actionIcon, contentDescription = null)
                }
            }
        },
        modifier = modifier,
        colors = TopAppBarDefaults.topAppBarColors()
    )
} 