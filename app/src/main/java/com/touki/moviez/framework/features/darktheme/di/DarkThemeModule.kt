package com.touki.moviez.framework.features.darktheme.di

import com.touki.moviez.core.features.darktheme.repository.DarkThemeRepository
import com.touki.moviez.core.usecases.darktheme.GetDarkTheme
import com.touki.moviez.core.usecases.darktheme.SetDarkTheme
import com.touki.moviez.framework.features.darktheme.preference.DarkThemePrefs
import com.touki.moviez.framework.features.darktheme.source.GetDarkThemeDataSourceImpl
import com.touki.moviez.framework.features.darktheme.source.SetDarkThemeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DarkThemeModule {

    @Provides
    fun provideGetDarkThemeDataSourceImpl(darkThemePrefs: DarkThemePrefs) = GetDarkThemeDataSourceImpl(darkThemePrefs)

    @Provides
    fun provideSetDarkThemeDataSourceImpl(darkThemePrefs: DarkThemePrefs) = SetDarkThemeDataSourceImpl(darkThemePrefs)

    @Provides
    fun provideMoviesRepository(
        setDarkThemeDataSourceImpl: SetDarkThemeDataSourceImpl,
        getDarkThemeDataSourceImpl: GetDarkThemeDataSourceImpl) =
        DarkThemeRepository(
            setDarkThemeDataSource = setDarkThemeDataSourceImpl,
            getDarkThemeDataSource = getDarkThemeDataSourceImpl
        )

    @Provides
    fun provideGetDarkTheme(darkThemeRepository: DarkThemeRepository) = GetDarkTheme(darkThemeRepository)

    @Provides
    fun provideSetDarkTheme(darkThemeRepository: DarkThemeRepository) = SetDarkTheme(darkThemeRepository)
}