package com.asoom.caffio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.asoom.caffio.presentation.screen.coffeeDetails.CoffeeDetailsScreen
import com.asoom.caffio.presentation.screen.home.HomeScreen
import com.asoom.caffio.presentation.screen.readyCoffee.ReadyCoffeeScreen
import com.asoom.caffio.presentation.screen.selectCoffee.SelectCoffeeScreen
import com.asoom.caffio.presentation.screen.snack.SnackScreen
import com.asoom.caffio.presentation.screen.orderComplete.OrderCompleteScreen
import com.asoom.caffio.presentation.utils.ObserveAsEvents
import org.koin.compose.koinInject

val LocalNavController = compositionLocalOf<NavHostController> { error("No Nav Controller Found") }


@Composable
fun CaffeineNavGraph(navController: NavHostController, navigator: Navigator = koinInject()) {

    ObserveAsEvents(navigator.navigationEvent) { event ->
        when (event) {
            is NavigationEvent.Navigate -> navController.navigate(
                route = event.destination, navOptions = event.navOptions
            )

            NavigationEvent.NavigateUp -> navController.navigateUp()
        }
    }

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {

        NavHost(
            navController = navController,
            startDestination = navigator.startGraph,
        ) {
            buildCaffeineNavGraph(navController)
        }

    }
}

fun NavGraphBuilder.buildCaffeineNavGraph(navController: NavController) {
    navigation<Destinations.CaffeineGraph>(startDestination = Destinations.Home) {
        composable<Destinations.Home> { HomeScreen() }
        composable<Destinations.SelectCoffee> { SelectCoffeeScreen() }
        composable<Destinations.CoffeeDetails> { CoffeeDetailsScreen(navController = navController) }
        composable<Destinations.ReadyCoffee> { ReadyCoffeeScreen() }
        composable<Destinations.Snack> { SnackScreen() }
        composable<Destinations.OrderComplete> { OrderCompleteScreen() }
    }
}