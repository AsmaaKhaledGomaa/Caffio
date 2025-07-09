package com.asoom.caffio.presentation.screen.coffeeDetails

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.toRoute
import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel

class CoffeeDetailsViewModel(
    savedStateHandle: SavedStateHandle
) : BaseViewModel<CoffeeDetailsUiState>(CoffeeDetailsUiState()) , CoffeeDetailsInteractionListener {

    private val destination = savedStateHandle.toRoute<Destinations.CoffeeDetails>()

    init {
        val coffeeType = destination.type
        updateUiState { it.copy(type = coffeeType) }
    }
    override fun onClickButton() {
        navigate(Destinations.DeliverCoffee)
    }

    override fun onClickBack() {
        navigateUp()
    }

}