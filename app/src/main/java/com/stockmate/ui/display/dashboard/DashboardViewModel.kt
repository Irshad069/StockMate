package com.stockmate.ui.display.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stockmate.ui.display.dashboard.data.model.Product
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    var state by mutableStateOf(DashboardScreenState())
        private set

    fun actionEvent(actionEvents: ActionEvent) {
        when (actionEvents) {
            is ActionEvent.LoadProducts -> loadProducts()
        }
    }

    private fun loadProducts() {
        state = state.copy(isLoading = true)

        viewModelScope.launch {
            val products = listOf(
                Product("Laptop", 5, "High-performance laptop"),
                Product("Smartphone", 10, "Latest smartphone model"),
                Product("Headphones", 15, "Noise-canceling headphones"),
                Product("Monitor", 7, "Full HD 24-inch monitor"),
                Product("Keyboard", 12, "Mechanical keyboard")
            )

            state = state.copy(isLoading = false, products = products)
        }
    }

    sealed class ActionEvent {
        data object LoadProducts : ActionEvent()
    }
}