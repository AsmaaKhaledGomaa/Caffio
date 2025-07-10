package com.asoom.caffio.presentation.screen.coffeeDetails

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.asoom.caffio.R
import com.asoom.caffio.core.ui.components.*
import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.ui.theme.brawn
import com.asoom.caffio.core.designSystem.CaffioTypography
import kotlinx.coroutines.delay
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CoffeeDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: CoffeeDetailsViewModel = koinViewModel(),
    navController: NavController
) {
    val uiState by viewModel.uiState.collectAsState()
    val cupSize = remember { mutableStateOf(CupSize.Medium) }
    val coffeeLevel = remember { mutableStateOf("Low") }
    val beanCount = remember { mutableStateOf(0) }
    var previousLevel by remember { mutableStateOf("Low") }
    val isReversed = remember { mutableStateOf(false) }
    var hideHeader by remember { mutableStateOf(false) }
    var showProgress by remember { mutableStateOf(false) }
    var animationFinished by remember { mutableStateOf(false) }

    LaunchedEffect(coffeeLevel.value) {
        val current = when (coffeeLevel.value) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }
        val previous = when (previousLevel) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }
        isReversed.value = current < previous
        if (current != previous) {
            beanCount.value++
        }
        previousLevel = coffeeLevel.value
    }

    val cupImageSize by animateDpAsState(
        targetValue = when (cupSize.value) {
            CupSize.Small -> 200.dp
            CupSize.Medium -> 250.dp
            CupSize.Large -> 320.dp
        }, label = "CupImageSize"
    )

    val logoImageSize by animateDpAsState(
        targetValue = when (cupSize.value) {
            CupSize.Small -> 50.dp
            CupSize.Medium -> 60.dp
            CupSize.Large -> 90.dp
        }, label = "LogoImageSize"
    )

    LaunchedEffect(hideHeader) {
        if (hideHeader) {
            delay(600)
            showProgress = true
        }
    }

    LaunchedEffect(showProgress) {
        if (showProgress && !animationFinished) {
            delay(9000)
            animationFinished = true
            navController.navigate(Destinations.ReadyCoffee)
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            AnimatedVisibility(
                visible = !hideHeader,
                exit = fadeOut(tween(600)) + slideOutVertically(
                    targetOffsetY = { -it },
                    animationSpec = tween(600)
                )
            ) {
                CaffioTopAppBar(
                    title = uiState.type,
                    navigationButton = {
                        ActionButton(
                            onClick = { viewModel.onClickBack() },
                            actionIcon = R.drawable.icon_back,
                        )
                    },
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(341.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 60.dp)
                    .zIndex(1f)
            ) {
                CoffeeBeanAnimation(
                    coffeeLevel = coffeeLevel.value,
                    beanCount = beanCount.value,
                    modifier = Modifier.align(Alignment.Center)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_starbuks),
                    contentDescription = "Cup",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(cupImageSize)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_starbuks_logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(logoImageSize)
                )

                val ml by remember {
                    derivedStateOf {
                        when (cupSize.value) {
                            CupSize.Small -> "150 ML"
                            CupSize.Medium -> "200 ML"
                            CupSize.Large -> "400 ML"
                        }
                    }
                }

                Text(
                    text = ml,
                    color = Color.Black.copy(alpha = 0.6f),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 64.dp, start = 16.dp)
                )
            }

            AnimatedVisibility(visible = !hideHeader, exit = fadeOut(tween(600))) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    SizeSwitch(
                        selectedSize = cupSize.value,
                        onSizeSelected = { cupSize.value = it },
                    )
                }
            }

            AnimatedVisibility(visible = !hideHeader, exit = fadeOut(tween(600))) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CaffioSwitch(
                        selectedLevel = coffeeLevel.value,
                        onLevelChanged = { coffeeLevel.value = it },
                    )
                }
            }

            AnimatedVisibility(visible = !hideHeader, exit = fadeOut(tween(600))) {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CaffioButton(
                        text = "Continue",
                        icon = R.drawable.ic_arrow,
                        onClick = { hideHeader = true },
                        modifier = Modifier
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))
        }

        AnimatedVisibility(
            visible = showProgress,
            enter = fadeIn(tween(1000))
        ) {
            ProgressContent(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.BottomCenter)
            )
        }
    }
}

@Composable
fun CoffeeBeanAnimation(
    coffeeLevel: String,
    beanCount: Int,
    modifier: Modifier = Modifier
) {
    var showFalling by remember { mutableStateOf(false) }
    var showRising by remember { mutableStateOf(false) }
    var previousLevel by remember { mutableStateOf("Low") }

    LaunchedEffect(coffeeLevel, beanCount) {
        val previous = when (previousLevel) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }
        val current = when (coffeeLevel) {
            "Low" -> 0
            "Medium" -> 1
            "High" -> 2
            else -> 0
        }

        if (current > previous) {
            showFalling = true
            showRising = false
            delay(1400)
            showFalling = false
        } else if (current < previous) {
            showRising = true
            showFalling = false
            delay(1400)
            showRising = false
        }

        previousLevel = coffeeLevel
    }

    val scaleFalling by animateFloatAsState(
        targetValue = if (showFalling) 0.6f else 1.5f,
        animationSpec = tween(1000),
        label = "FallingScale"
    )

    val scaleRising by animateFloatAsState(
        targetValue = if (showRising) 0.7f else 1.5f,
        animationSpec = tween(1000),
        label = "RisingScale"
    )

    val animatedOffsetY by animateFloatAsState(
        targetValue = if (showRising) -1600f else 0f,
        animationSpec = tween(1600),
        label = "RisingOffset"
    )

    Box(modifier = modifier.fillMaxSize()) {
        AnimatedVisibility(
            visible = showFalling,
            enter = slideInVertically(
                initialOffsetY = { -it * 3 },
                animationSpec = tween(1100)
            ) + fadeIn(tween(500)),
            exit = fadeOut(tween(400)),
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_coffee_beans),
                contentDescription = "coffee falling",
                modifier = Modifier
                    .size(180.dp)
                    .offset(y = 30.dp)
                    .graphicsLayer {
                        scaleX = scaleFalling
                        scaleY = scaleFalling
                    },
                tint = Color.Unspecified
            )
        }

        if (showRising) {
            Icon(
                painter = painterResource(id = R.drawable.icon_coffee_beans),
                contentDescription = "coffee rising",
                modifier = Modifier
                    .align(Alignment.Center)
                    .graphicsLayer {
                        translationY = animatedOffsetY
                        val progress = (animatedOffsetY / -1200f).coerceIn(0f, 1f)
                        scaleX = 0.15f + (0.9f * progress)
                        scaleY = 0.2f + (0.9f * progress)
                    }
                    .size(180.dp),
                tint = Color.Unspecified
            )
        }
    }
}

@Composable
private fun ProgressContent(modifier: Modifier = Modifier) {
    var showAll by remember { mutableStateOf(false) }
    LaunchedEffect(Unit) {
        delay(150)
        showAll = true
    }
    val allAlpha by animateFloatAsState(
        targetValue = if (showAll) 1f else 0f,
        animationSpec = tween(500),
        label = "allAlpha"
    )
    Box(
        modifier = modifier.graphicsLayer { alpha = allAlpha }
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 64.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedWaveProgressBar(startAnimation = showAll)
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Almost Done",
                    style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Your coffee will be finish in",
                    color = Color(0xFF1F1F1F).copy(alpha = 0.6f),
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "CO",
                    color = brawn,
                    style = CaffioTypography.labelMedium
                )
                Image(
                    painter = painterResource(R.drawable.ic_colon),
                    contentDescription = "Colon",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "FF",
                    color = brawn,
                    style = CaffioTypography.labelMedium
                )
                Image(
                    painter = painterResource(R.drawable.ic_colon),
                    contentDescription = "Colon",
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .align(Alignment.CenterVertically)
                )
                Text(
                    text = "EE",
                    color = brawn,
                    style = CaffioTypography.labelMedium
                )
            }
        }
    }
}
