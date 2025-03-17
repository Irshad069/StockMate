package com.stockmate.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {

    @Serializable
    data object DashboardDisplay : Screens()

    @Serializable
    data object SettingDisplay : Screens()

    @Serializable
    data object OrderDisplay : Screens()

}