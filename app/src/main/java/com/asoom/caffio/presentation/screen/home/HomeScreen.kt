package com.asoom.caffio.presentation.screen.home

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
import com.asoom.caffio.core.ui.components.ActionButton
import com.asoom.caffio.core.ui.components.AnimatedStar
import com.asoom.caffio.core.ui.components.CaffioButton
import com.asoom.caffio.core.ui.components.CaffioGhost
import com.asoom.caffio.core.ui.components.CaffioTopAppBar
import org.koin.compose.koinInject

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinInject()
) {

    Column(
        modifier = modifier
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
            onClickActionButton = {
                ActionButton(
                    onClick = {},
                    actionIcon = R.drawable.icon_add,
                )
            }
        )
        HocusText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 26.dp)
        )
        CaffioGhost(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 33.dp)
        )

        Spacer(modifier = Modifier.weight(1f))

        CaffioButton(
            text = stringResource(R.string.bring_my_coffee),
            icon = R.drawable.ic_coffee_mag,
            onClick = { viewModel.onClickButton() },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp),
        )
    }
}

@Composable
fun HocusText(
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
            .size(height = 200.dp, width = 216.dp)
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
        AnimatedStar(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 26.dp, top = 58.dp)
        )
        AnimatedStar(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 2.dp, end = 18.dp)
        )

        AnimatedStar(
            modifier = Modifier
                .align(Alignment.BottomEnd)
        )
    }

}


@ThemePreviews
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}
