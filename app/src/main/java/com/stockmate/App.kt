package com.stockmate

import android.app.Application
import com.stockmate.ui.di.DIManager

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        DIManager.initialize(this)
    }
}