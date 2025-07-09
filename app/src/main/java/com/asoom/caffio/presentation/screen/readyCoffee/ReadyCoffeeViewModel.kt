package com.asoom.caffio.presentation.screen.readyCoffee

import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel

class ReadyCoffeeViewModel(

) : BaseViewModel<ReadyCoffeeUiState>(ReadyCoffeeUiState()) , ReadyCoffeeInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.Snack)
    }

}