package com.touki.moviez.framework.features.settings.preference

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class SettingPrefs @Inject constructor(
    private val sharedPrefs: SharedPreferences
) {
    companion object {
        private const val KEY_DARK_THEME = "dark_theme_enabled"
    }

    var darkThemeEnabled : Boolean
        set(value) = sharedPrefs.edit {
            putBoolean(KEY_DARK_THEME, value)
        }
        get() = sharedPrefs.getBoolean(KEY_DARK_THEME, false)

}