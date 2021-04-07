package com.touki.moviez.core.features.darktheme.repository

import com.touki.moviez.core.features.darktheme.domain.DarkTheme
import com.touki.moviez.core.features.darktheme.source.GetDarkThemeDataSource
import com.touki.moviez.core.features.darktheme.source.SetDarkThemeDataSource
import com.touki.moviez.core.usecases.UseCaseResult

class DarkThemeRepository(
    private val setDarkThemeDataSource: SetDarkThemeDataSource,
    private val getDarkThemeDataSource: GetDarkThemeDataSource) {
    fun setDarkTheme(enabled: Boolean): UseCaseResult<DarkTheme> {
        return setDarkThemeDataSource(enabled)
    }

    fun getDarkTheme() : Boolean {
        return getDarkThemeDataSource()
    }
}