package com.asoom.caffio.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation
import com.asoom.caffio.presentation.screen.home.HomeScreen
import kotlinx.serialization.Serializable
import androidx.navigation.compose.composable
import com.asoom.caffio.presentation.screen.coffeeDetails.CoffeeDetailsScreen
import com.asoom.caffio.presentation.screen.deliverCoffee.DeliverCoffeeScreen
import com.asoom.caffio.presentation.screen.readyCoffee.ReadyCoffeeScreen
import com.asoom.caffio.presentation.screen.selectCoffee.SelectCoffeeScreen
import com.asoom.caffio.presentation.screen.snack.SnackScreen
import com.asoom.caffio.presentation.screen.thankYou.ThankYouScreen

sealed interface Destinations : Graph {

    @Serializable
    data object CaffeineGraph : Graph

    @Serializable
    data object Home : Destination

    @Serializable
    data object SelectCoffee : Destination

    @Serializable
    data class CoffeeDetails(val type: String) : Destination

    @Serializable
    data object DeliverCoffee : Destination

    @Serializable
    data object ReadyCoffee : Destination

    @Serializable
    data object Snak : Destination

    @Serializable
    data object ThankYouu : Destination
}