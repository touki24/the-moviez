package com.touki.moviez

import android.app.Application
import com.touki.moviez.core.Interactors
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App: Application() {

    @Inject lateinit var interactors: Interactors

    override fun onCreate() {
        super.onCreate()
        interactors.setDarkTheme(interactors.getDarkTheme())
    }
}