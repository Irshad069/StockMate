package com.stockmate.ui.display.dashboard

import com.stockmate.ui.display.dashboard.data.model.Product

data class DashboardScreenState(
    val title: String = "StockMate",
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList()
)
