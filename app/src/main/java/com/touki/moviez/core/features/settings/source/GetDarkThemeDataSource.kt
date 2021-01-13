package com.touki.moviez.core.features.settings.source

import com.touki.moviez.core.features.settings.domain.DarkTheme
import com.touki.moviez.core.usecases.UseCaseResult

interface GetDarkThemeDataSource {
    operator fun invoke() : Boolean
}