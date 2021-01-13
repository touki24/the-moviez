package com.touki.moviez.core.features.settings.repository

import com.touki.moviez.core.features.settings.domain.DarkTheme
import com.touki.moviez.core.features.settings.source.GetDarkThemeDataSource
import com.touki.moviez.core.features.settings.source.SetDarkThemeDataSource
import com.touki.moviez.core.usecases.UseCaseResult

class SettingRepository(
    private val setDarkThemeDataSource: SetDarkThemeDataSource,
    private val getDarkThemeDataSource: GetDarkThemeDataSource) {
    fun setDarkTheme(enabled: Boolean): UseCaseResult<DarkTheme> {
        return setDarkThemeDataSource(enabled)
    }

    fun getDarkTheme() : Boolean {
        return getDarkThemeDataSource()
    }
}