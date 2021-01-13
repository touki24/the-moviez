package com.touki.moviez.framework.main.di

import android.content.Context
import android.content.SharedPreferences
import com.touki.moviez.core.Interactors
import com.touki.moviez.core.usecases.movies.GetMovies
import com.touki.moviez.core.usecases.settings.GetDarkTheme
import com.touki.moviez.core.usecases.settings.SetDarkTheme
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
        getDarkTheme: GetDarkTheme
    ) =
        Interactors(
            getMovies = getMovies,
            setDarkTheme = setDarkTheme,
            getDarkTheme = getDarkTheme
        )
}