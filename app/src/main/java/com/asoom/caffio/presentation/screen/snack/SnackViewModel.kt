package com.asoom.caffio.presentation.screen.snack

import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel

class SnackViewModel() : BaseViewModel<SnackUiState>(SnackUiState()), SnackInteractionListener {

    override fun onClickCard() {
        navigate(Destinations.OrderComplete)
    }
}