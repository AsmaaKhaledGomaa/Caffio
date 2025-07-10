package com.asoom.caffio.presentation.screen.selectCoffee

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.asoom.caffio.R
import com.asoom.caffio.core.designSystem.theme.CaffioTheme
import com.asoom.caffio.core.ui.components.ActionButton
import com.asoom.caffio.core.ui.components.CaffioButton
import com.asoom.caffio.core.ui.components.CaffioTopAppBar
import org.koin.compose.koinInject
import kotlin.math.abs

@Composable
fun SelectCoffeeScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectCoffeeViewModel = koinInject()
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
        GoodMorningText("Asmaa", modifier = Modifier.padding(top = 16.dp, start = 4.dp))

        val selectedIndex = rememberSaveable { mutableStateOf(0) }
        if (selectedIndex.value !in coffeeNamesList.indices) {
            selectedIndex.value = 0
        }
        val selectedCoffeeName =
            coffeeNamesList.getOrNull(selectedIndex.value) ?: coffeeNamesList[0]

        ZoomPager(
            items = itemsList,
            modifier = Modifier
                .padding(top = 106.dp),
            onItemSelected = { index ->
                selectedIndex.value = index
            }
        )

        Spacer(modifier = Modifier.weight(1f))

        CaffioButton(
            text = stringResource(R.string.continue_coffio),
            icon = R.drawable.icon_arrow_right,
            onClick = {
                viewModel.onClickButton(selectedCoffeeName)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 50.dp),
        )
    }
}

val itemsList = listOf(
    R.drawable.black,
    R.drawable.macchiato,
    R.drawable.latte,
    R.drawable.espresso
)

val coffeeNamesList = listOf(
    "Black",
    "Macchiato",
    "Latte",
    "Espresso"
)

@Composable
fun GoodMorningText(
    name: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.background(CaffioTheme.colors.surface)
    ) {

        Text(
            text = stringResource(R.string.good_morning),
            color = CaffioTheme.colors.onSecondry,
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = "$name ☀",
            color = CaffioTheme.colors.primaryContainer,
            style = TextStyle(
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Text(
            text = stringResource(R.string.what_would_you_like_to_drink),
            color = Color(0xFF1F1F1F).copy(alpha = 0.8f),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun ZoomPager(
    items: List<Int>,
    modifier: Modifier = Modifier,
    onItemSelected: (Int) -> Unit
) {
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { items.size }
    )


    LaunchedEffect(pagerState.currentPage) {
        onItemSelected(pagerState.currentPage)
    }

    HorizontalPager(
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(horizontal = 100.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) { page ->

        val pageOffset = (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
        val scale = 1.5f - abs(pageOffset) * 0.6f

        Box(
            modifier = Modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                }
                .padding(8.dp)
                .fillMaxWidth()
                .height(200.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = items[page]),
                contentDescription = null,
                modifier = Modifier
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview() {
    SelectCoffeeScreen()
}