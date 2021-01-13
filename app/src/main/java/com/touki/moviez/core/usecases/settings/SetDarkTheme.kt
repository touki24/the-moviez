package com.touki.moviez.core.usecases.settings

import com.touki.moviez.core.features.settings.domain.DarkTheme
import com.touki.moviez.core.features.settings.repository.SettingRepository
import com.touki.moviez.core.usecases.UseCaseResult

class SetDarkTheme(private val settingRepository: SettingRepository) {
    operator fun invoke(enabled: Boolean) : UseCaseResult<DarkTheme> {
        return settingRepository.setDarkTheme(enabled)
    }
}