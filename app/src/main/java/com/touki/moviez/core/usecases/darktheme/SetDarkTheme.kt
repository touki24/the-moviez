package com.touki.moviez.core.usecases.darktheme

import com.touki.moviez.core.features.darktheme.domain.DarkTheme
import com.touki.moviez.core.features.darktheme.repository.DarkThemeRepository
import com.touki.moviez.core.usecases.UseCaseResult

class SetDarkTheme(private val settingRepository: DarkThemeRepository) {
    operator fun invoke(enabled: Boolean) : UseCaseResult<DarkTheme> {
        return settingRepository.setDarkTheme(enabled)
    }
}