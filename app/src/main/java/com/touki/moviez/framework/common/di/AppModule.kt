package com.touki.moviez.framework.common.di

import android.content.Context
import android.content.SharedPreferences
import com.touki.moviez.core.Interactors
import com.touki.moviez.core.usecases.auth.SignInByUserPass
import com.touki.moviez.core.usecases.auth.ValidateUserPass
import com.touki.moviez.core.usecases.movies.GetMovies
import com.touki.moviez.core.usecases.darktheme.GetDarkTheme
import com.touki.moviez.core.usecases.darktheme.SetDarkTheme
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

const val PREFS_NAME = "shared_prefs"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideSharedPrefs(@ApplicationContext context: Context) : SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    @Provides
    fun provideInteractors(
        getMovies: GetMovies,
        setDarkTheme: SetDarkTheme,
        getDarkTheme: GetDarkTheme,
        signInByUserPass: SignInByUserPass,
        validateUserPass: ValidateUserPass
    ) =
        Interactors(
            getMovies = getMovies,
            setDarkTheme = setDarkTheme,
            getDarkTheme = getDarkTheme,
            signInByUserPass = signInByUserPass,
            validateUserPass = validateUserPass
        )
}