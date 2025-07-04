package com.asoom.caffio.presentation.navigation


sealed class Screen(val route: String) {
    object Home : Screen("home")
    object CoffeeDetails : Screen("coffee_details/{coffeeId}") {
        fun createRoute(coffeeId: String) = "coffee_details/$coffeeId"
    }
    object Snack : Screen("snack")
}
