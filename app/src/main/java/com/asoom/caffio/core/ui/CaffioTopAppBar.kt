package com.asoom.caffio.core.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CaffioTopAppBar(
    title: String,
    navigationIcon: ImageVector,
    onNavigationClick: () -> Unit,
    modifier: Modifier = Modifier,
    actionIcon: ImageVector? = null,
    onActionClick: (() -> Unit)? = null,
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
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewCaffioTopAppBar() {
    CaffioTopAppBar(
        title = "Macchiato",
        navigationIcon = Icons.Filled.ArrowBack,
        onNavigationClick = {}
    )
} 