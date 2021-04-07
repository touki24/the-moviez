package com.touki.moviez.framework.features.darktheme.source

import androidx.appcompat.app.AppCompatDelegate
import com.touki.moviez.core.features.darktheme.domain.DarkTheme
import com.touki.moviez.core.features.darktheme.source.SetDarkThemeDataSource
import com.touki.moviez.core.usecases.UseCaseResult
import com.touki.moviez.framework.features.darktheme.preference.DarkThemePrefs

class SetDarkThemeDataSourceImpl(private val darkThemePrefs: DarkThemePrefs): SetDarkThemeDataSource {

    override fun invoke(enabled: Boolean): UseCaseResult<DarkTheme> {
        return try {
            val defaultNightMode = if (enabled) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(defaultNightMode)
            darkThemePrefs.darkThemeEnabled = enabled
            UseCaseResult.Success(DarkTheme(enabled))
        } catch (e: Exception) {
            darkThemePrefs.darkThemeEnabled = false
            UseCaseResult.Failure("", e.message.toString())
        }
    }
}