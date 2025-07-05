package com.asoom.caffio.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.asoom.caffio.presentation.coffeeDetails.CoffeeDetailsScreen
import com.asoom.caffio.presentation.home.HomeScreen
import com.asoom.caffio.presentation.snack.SnackScreen


@Composable
fun CaffioNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onCoffeeClick = { coffeeId ->
                    navController.navigate(Screen.CoffeeDetails.createRoute(coffeeId))
                },
                onSnackClick = {
                    navController.navigate(Screen.Snack.route)
                }
            )
        }

        composable(
            route = Screen.CoffeeDetails.route,
            arguments = listOf(navArgument("coffeeId") { type = NavType.StringType })
        ) { backStackEntry ->
            val coffeeId = backStackEntry.arguments?.getString("coffeeId")
            CoffeeDetailsScreen(coffeeId = coffeeId)
        }

        composable(Screen.Snack.route) {
            SnackScreen()
        }
    }
}
