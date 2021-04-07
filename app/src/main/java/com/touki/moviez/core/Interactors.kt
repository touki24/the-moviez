package com.touki.moviez.core

import com.touki.moviez.core.usecases.auth.SignInByUserPass
import com.touki.moviez.core.usecases.auth.ValidateUserPass
import com.touki.moviez.core.usecases.movies.GetMovies
import com.touki.moviez.core.usecases.darktheme.GetDarkTheme
import com.touki.moviez.core.usecases.darktheme.SetDarkTheme

data class Interactors(
    val getMovies: GetMovies,
    val setDarkTheme: SetDarkTheme,
    val getDarkTheme: GetDarkTheme,
    val signInByUserPass: SignInByUserPass,
    val validateUserPass: ValidateUserPass
)