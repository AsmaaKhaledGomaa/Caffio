package com.asoom.caffio.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.asoom.caffio.presentation.navigation.CaffeineNavGraph
import com.asoom.caffio.presentation.navigation.Navigator
import org.koin.compose.koinInject

@Composable
fun CaffioApp() {
    val navController = rememberNavController()
    val navigator: Navigator = koinInject()
    Box(
        modifier = Modifier.statusBarsPadding()
    ) {
        CaffeineNavGraph(navController, navigator)
    }
}