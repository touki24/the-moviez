package com.touki.moviez.framework.features.settings.di

import com.touki.moviez.core.features.settings.repository.SettingRepository
import com.touki.moviez.core.usecases.settings.GetDarkTheme
import com.touki.moviez.core.usecases.settings.SetDarkTheme
import com.touki.moviez.framework.features.settings.preference.SettingPrefs
import com.touki.moviez.framework.features.settings.source.GetDarkThemeDataSourceImpl
import com.touki.moviez.framework.features.settings.source.SetDarkThemeDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object SettingModule {

    @Provides
    fun provideGetDarkThemeDataSourceImpl(settingPrefs: SettingPrefs) = GetDarkThemeDataSourceImpl(settingPrefs)

    @Provides
    fun provideSetDarkThemeDataSourceImpl(settingPrefs: SettingPrefs) = SetDarkThemeDataSourceImpl(settingPrefs)

    @Provides
    fun provideMoviesRepository(
        setDarkThemeDataSourceImpl: SetDarkThemeDataSourceImpl,
        getDarkThemeDataSourceImpl: GetDarkThemeDataSourceImpl) =
        SettingRepository(
            setDarkThemeDataSource = setDarkThemeDataSourceImpl,
            getDarkThemeDataSource = getDarkThemeDataSourceImpl
        )

    @Provides
    fun provideGetDarkTheme(settingRepository: SettingRepository) = GetDarkTheme(settingRepository)

    @Provides
    fun provideSetDarkTheme(settingRepository: SettingRepository) = SetDarkTheme(settingRepository)
}