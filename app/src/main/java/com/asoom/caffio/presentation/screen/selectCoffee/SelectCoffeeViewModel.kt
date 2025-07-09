package com.asoom.caffio.presentation.screen.selectCoffee

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.screen.base.BaseViewModel

class SelectCoffeeViewModel(
) : BaseViewModel<SelectCoffeeUiState>(SelectCoffeeUiState()), SelectCoffeeInteractionListener {

    private val _selectedIndex = mutableStateOf(0)
    val selectedIndex: State<Int> = _selectedIndex

    fun onCoffeeSelected(index: Int) {
        _selectedIndex.value = index
    }

    override fun onClickButton(selectedCoffee: String) {
        navigate(Destinations.CoffeeDetails(selectedCoffee))
    }

}