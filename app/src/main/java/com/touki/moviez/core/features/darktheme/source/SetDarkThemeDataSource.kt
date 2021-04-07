package com.touki.moviez.core.features.darktheme.source

import com.touki.moviez.core.features.darktheme.domain.DarkTheme
import com.touki.moviez.core.usecases.UseCaseResult

interface SetDarkThemeDataSource {
    operator fun invoke(enabled: Boolean) : UseCaseResult<DarkTheme>
}