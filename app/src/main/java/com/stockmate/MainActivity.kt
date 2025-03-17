package com.stockmate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.stockmate.ui.navigation.MainNavGraph
import com.stockmate.ui.theme.StockMateTheme
import org.koin.compose.KoinContext

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMateTheme {
                KoinContext {
                    MainNavGraph(
                        navController = rememberNavController(),
                        modifier = Modifier
                    )
                }
            }
        }
    }
}
