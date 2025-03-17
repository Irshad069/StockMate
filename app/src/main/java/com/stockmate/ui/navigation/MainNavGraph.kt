package com.stockmate.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.stockmate.ui.display.dashboard.DashboardScreen
import com.stockmate.ui.display.dashboard.DashboardViewModel
import com.stockmate.ui.display.order.OrderScreen
import com.stockmate.ui.display.order.OrderViewModel
import com.stockmate.ui.display.setting.SettingScreen
import com.stockmate.ui.display.setting.SettingViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screens.DashboardDisplay,

        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Left,
                animationSpec = tween(700)
            )
        },
        popEnterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        },
        popExitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }
    ) {
        composable<Screens.DashboardDisplay> {
            val viewModel: DashboardViewModel = koinViewModel()
            DashboardScreen(
                state = viewModel.state,
                actionEvent = viewModel::actionEvent,
                onSettingClick = {
                    navController.navigate(Screens.SettingDisplay)
                },
                onOrderClick = {
                    navController.navigate(Screens.OrderDisplay)
                }
            )
        }
        composable<Screens.SettingDisplay> {
            val viewModel: SettingViewModel = koinViewModel()
            SettingScreen(
                state = viewModel.state,
                actionEvent = viewModel::actionEvent,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable<Screens.OrderDisplay> {
            val viewModel: OrderViewModel = koinViewModel()
            OrderScreen(
                state = viewModel.state,
                actionEvent = viewModel::actionEvent,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}