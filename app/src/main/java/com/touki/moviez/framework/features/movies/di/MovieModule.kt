package com.touki.moviez.framework.features.movies.di

import com.touki.moviez.core.features.movies.repository.MoviesRepository
import com.touki.moviez.core.usecases.movies.GetMovies
import com.touki.moviez.framework.features.movies.source.GetMoviesDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    @Provides
    fun provideGetMoviesDataSourceImpl() = GetMoviesDataSourceImpl()

    @Provides
    fun provideMoviesRepository(getMoviesDataSourceImpl: GetMoviesDataSourceImpl) =
        MoviesRepository(getMoviesDataSource = getMoviesDataSourceImpl)

    @Provides
    fun provideGetMovies(moviesRepository: MoviesRepository) = GetMovies(moviesRepository)
}