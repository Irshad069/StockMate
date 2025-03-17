package com.stockmate.ui.di

import com.stockmate.ui.display.dashboard.data.repo.DashboardRepo
import com.stockmate.ui.display.dashboard.data.repo.DashboardRepoImpl
import org.koin.dsl.module

val dashboardRepoModule = module {
    single<DashboardRepo> {
        DashboardRepoImpl()
    }
}
