package com.stockmate.ui.display.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.stockmate.ui.components.BaseToolBar
import com.stockmate.ui.utils.sdp

@Composable
fun SettingScreen(
    state: SettingScreenState = SettingScreenState(),
    actionEvent: (SettingViewModel.ActionEvent) -> Unit = {},
    onBackClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier.padding(horizontal = 20.sdp)
    ) {
        BaseToolBar(
            title = state.title,
            showBackButton = true,
            onBackClick = {onBackClick()}
        )
    }
}