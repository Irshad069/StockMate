package com.stockmate.ui.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

@Composable
fun Dp.addBottomInset(): Dp {
    return this + getBottomInsets()
}

@Composable
fun Dp.addTopInset(): Dp {
    return this + getTopInsets()
}

@Composable
fun getBottomInsets(): Dp {
    return WindowInsets.safeDrawing
        .only(WindowInsetsSides.Bottom)
        .asPaddingValues().calculateBottomPadding()
}

@Composable
fun getTopInsets(): Dp {
    return WindowInsets.safeDrawing
        .only(WindowInsetsSides.Top)
        .asPaddingValues().calculateTopPadding()
}