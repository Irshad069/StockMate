package com.stockmate.ui.display.order

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    var state by mutableStateOf(OrderScreenState())
        private set

    fun actionEvent(actionEvent: ActionEvent){

    }

    sealed class ActionEvent
}