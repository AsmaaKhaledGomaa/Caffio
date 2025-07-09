package com.asoom.caffio.presentation.navigation

import kotlinx.serialization.Serializable

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
    data object ReadyCoffee : Destination

    @Serializable
    data object Snack : Destination

    @Serializable
    data object OrderComplete : Destination
}