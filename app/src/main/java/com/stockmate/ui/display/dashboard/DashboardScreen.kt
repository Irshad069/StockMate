package com.stockmate.ui.display.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.stockmate.ui.components.BaseToolBar
import com.stockmate.ui.components.ProductCard
import com.stockmate.ui.components.ProfileSection
import com.stockmate.ui.utils.addBottomInset
import com.stockmate.ui.utils.sdp

@Composable
fun DashboardScreen(
    state: DashboardScreenState = DashboardScreenState(),
    actionEvent: (DashboardViewModel.ActionEvent) -> Unit = {},
    onSettingClick: () -> Unit = {},
    onOrderClick: () -> Unit = {}
) {
    LaunchedEffect(Unit) {
        actionEvent.invoke(DashboardViewModel.ActionEvent.LoadProducts)
    }
    Column(
        modifier = Modifier.padding(horizontal = 20.sdp)
    ) {
        BaseToolBar(
            title = state.title,
            showBackButton = false
        )
        ProfileSection()
        Spacer(modifier = Modifier.height(16.sdp))
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(state.products) { product ->
                    ProductCard(product)
                    Spacer(modifier = Modifier.height(8.sdp))
                }
            }
        }
        Spacer(modifier = Modifier.height(16.sdp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.sdp.addBottomInset()),
            horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = {onSettingClick()}
            ) {
                Text("Settings")
            }
            Button(
                onClick = { onOrderClick() }
            ) {
                Text("Orders")
            }
        }
    }
}