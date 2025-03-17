package com.stockmate.ui.display.setting

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingViewModel : ViewModel() {

    var state by mutableStateOf(SettingScreenState())
        private set

    fun actionEvent(actionEvent: ActionEvent){

    }

    sealed class ActionEvent

}