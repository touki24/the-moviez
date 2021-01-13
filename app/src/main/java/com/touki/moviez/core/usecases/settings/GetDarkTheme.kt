package com.touki.moviez.core.usecases.settings

import com.touki.moviez.core.features.settings.repository.SettingRepository

class GetDarkTheme(private val settingRepository: SettingRepository) {
    operator fun invoke(): Boolean {
        return settingRepository.getDarkTheme()
    }
}