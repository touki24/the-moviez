package com.touki.moviez.framework.features.darktheme.source

import com.touki.moviez.core.features.darktheme.source.GetDarkThemeDataSource
import com.touki.moviez.framework.features.darktheme.preference.DarkThemePrefs

class GetDarkThemeDataSourceImpl(private val darkThemePrefs: DarkThemePrefs): GetDarkThemeDataSource {

    override fun invoke(): Boolean {
        return darkThemePrefs.darkThemeEnabled
    }
}