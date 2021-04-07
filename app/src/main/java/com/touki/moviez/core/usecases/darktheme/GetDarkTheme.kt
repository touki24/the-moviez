package com.touki.moviez.core.usecases.darktheme

import com.touki.moviez.core.features.darktheme.repository.DarkThemeRepository

class GetDarkTheme(private val darkThemeRepository: DarkThemeRepository) {
    operator fun invoke(): Boolean {
        return darkThemeRepository.getDarkTheme()
    }
}