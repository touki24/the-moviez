package com.touki.moviez.core

import com.touki.moviez.core.usecases.movies.GetMovies
import com.touki.moviez.core.usecases.settings.GetDarkTheme
import com.touki.moviez.core.usecases.settings.SetDarkTheme

data class Interactors(
    val getMovies: GetMovies,
    val setDarkTheme: SetDarkTheme,
    val getDarkTheme: GetDarkTheme
)