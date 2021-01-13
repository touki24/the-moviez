package com.touki.moviez.framework.features.settings.source

import com.touki.moviez.core.features.settings.source.GetDarkThemeDataSource
import com.touki.moviez.framework.features.settings.preference.SettingPrefs

class GetDarkThemeDataSourceImpl(private val settingPrefs: SettingPrefs): GetDarkThemeDataSource {

    override fun invoke(): Boolean {
        return settingPrefs.darkThemeEnabled
    }
}