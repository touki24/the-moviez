package com.touki.moviez.framework.features.settings.source

import androidx.appcompat.app.AppCompatDelegate
import com.touki.moviez.core.features.settings.domain.DarkTheme
import com.touki.moviez.core.features.settings.source.SetDarkThemeDataSource
import com.touki.moviez.core.usecases.UseCaseResult
import com.touki.moviez.framework.features.settings.preference.SettingPrefs

class SetDarkThemeDataSourceImpl(private val settingPrefs: SettingPrefs): SetDarkThemeDataSource {

    override fun invoke(enabled: Boolean): UseCaseResult<DarkTheme> {
        return try {
            val defaultNightMode = if (enabled) {
                AppCompatDelegate.MODE_NIGHT_YES
            } else {
                AppCompatDelegate.MODE_NIGHT_NO
            }
            AppCompatDelegate.setDefaultNightMode(defaultNightMode)
            settingPrefs.darkThemeEnabled = enabled
            UseCaseResult.Success(DarkTheme(enabled))
        } catch (e: Exception) {
            settingPrefs.darkThemeEnabled = false
            UseCaseResult.Failure("", e.message.toString())
        }
    }
}