package com.touki.moviez.core.features.movies.repository

import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.core.features.movies.source.GetMoviesDataSource
import com.touki.moviez.core.usecases.UseCaseResult

class MoviesRepository(
    private val getMoviesDataSource: GetMoviesDataSource
) {
    suspend fun getMovies() : UseCaseResult<List<Movie>> {
        return getMoviesDataSource()
    }
}