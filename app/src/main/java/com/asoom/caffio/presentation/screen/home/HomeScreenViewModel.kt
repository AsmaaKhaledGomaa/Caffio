package com.asoom.caffio.presentation.screen.home

import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel


class HomeScreenViewModel() : BaseViewModel<HomeUiState>(HomeUiState()), HomeInteractionListener {
    override fun onClickButton() {
        navigate(Destinations.SelectCoffee)
    }
}