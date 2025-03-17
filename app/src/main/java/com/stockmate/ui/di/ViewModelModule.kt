package com.stockmate.ui.di

import com.stockmate.ui.display.dashboard.DashboardViewModel
import com.stockmate.ui.display.order.OrderViewModel
import com.stockmate.ui.display.setting.SettingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardViewModelModule = module {
    viewModel { DashboardViewModel() }
}
val settingViewModelModule = module {
    viewModel { SettingViewModel() }
}
val orderViewModelModule = module {
    viewModel { OrderViewModel() }
}