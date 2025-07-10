package com.asoom.caffio.presentation.screen.orderComplete

import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel

class OrderCompleteViewModel() : BaseViewModel<OrderCompleteUiState>(OrderCompleteUiState()),
    OrderCompleteInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.Home)
    }
}