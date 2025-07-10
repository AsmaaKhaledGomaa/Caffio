package com.asoom.caffio.di

import androidx.lifecycle.SavedStateHandle
import com.asoom.caffio.presentation.navigation.Destinations
import com.asoom.caffio.presentation.navigation.Navigator
import com.asoom.caffio.presentation.navigation.NavigatorImpl
import com.asoom.caffio.presentation.screen.coffeeDetails.CoffeeDetailsViewModel
import com.asoom.caffio.presentation.screen.home.HomeScreenViewModel
import com.asoom.caffio.presentation.screen.readyCoffee.ReadyCoffeeViewModel
import com.asoom.caffio.presentation.screen.selectCoffee.SelectCoffeeViewModel
import com.asoom.caffio.presentation.screen.snack.SnackViewModel
import com.asoom.caffio.presentation.screen.orderComplete.OrderCompleteViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { SelectCoffeeViewModel() }
    viewModel { OrderCompleteViewModel() }
    viewModel { SnackViewModel() }
    viewModel { ReadyCoffeeViewModel() }
    viewModel { (handle: SavedStateHandle) ->
        CoffeeDetailsViewModel(handle)
    }
    single<Navigator> { NavigatorImpl(startGraph = Destinations.CaffeineGraph) }
}
