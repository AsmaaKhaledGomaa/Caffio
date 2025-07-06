package com.asoom.caffio.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.designSystem.theme.ThemePreviews
import com.asoom.caffio.core.ui.ActionButton
import com.asoom.caffio.core.ui.BlurredOvalOverlay
import com.asoom.caffio.core.ui.CaffioButton
import com.asoom.caffio.core.ui.CaffioTopAppBar

@Composable
fun HomeScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(CaffioTheme.colors.surface)
            .statusBarsPadding()
            .padding(all = 12.dp)

    ) {
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

        Box(
            modifier = Modifier
                .padding(top = 24.dp)
                .size(height = 200.dp, width = 216.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.ghost),
                style = CaffioTheme.typography.headlineLarge,
                color = CaffioTheme.colors.textPrimary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .zIndex(2f)
                    .fillMaxWidth()
            )

            Image(
                painter = painterResource(R.drawable.icon_star),
                contentDescription = "Star Icon",
                modifier = Modifier
                    .zIndex(1f)
                    .align(Alignment.TopStart)
                    .padding(start = 26.dp, top = 58.dp)
            )

            Image(
                painter = painterResource(R.drawable.icon_star),
                contentDescription = "Star Icon",
                modifier = Modifier
                    .zIndex(1f)
                    .align(Alignment.TopEnd)
                    .padding(top = 2.dp, end = 18.dp)
            )

            Image(
                painter = painterResource(R.drawable.icon_star),
                contentDescription = "Star Icon",
                modifier = Modifier
                    .zIndex(1f)
                    .align(Alignment.BottomEnd)
            )
        }

        Image(
            painter = painterResource(R.drawable.ghost),
            contentDescription = "Ghost Coffe",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 33.dp)
                .size(244.dp)
        )

        BlurredOvalOverlay(modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.weight(1f))

        CaffioButton(
            text = stringResource(R.string.bring_my_coffee),
            icon = R.drawable.icon_cup,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp),
            onClick = {}
        )
    }
}

@ThemePreviews
@Composable
fun PreviewHomeScreen() {
    CaffioTheme {
        HomeScreen(
        )
    }
}