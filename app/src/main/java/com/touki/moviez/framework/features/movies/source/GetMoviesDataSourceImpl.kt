package com.touki.moviez.framework.features.movies.source

import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.core.features.movies.source.GetMoviesDataSource
import com.touki.moviez.core.usecases.UseCaseResult
import com.touki.moviez.dummies.apiGetMovies
import kotlinx.coroutines.delay

class GetMoviesDataSourceImpl: GetMoviesDataSource {
    override suspend fun invoke(): UseCaseResult<List<Movie>> {
        // get movies from api
        delay(3000)
        val response = apiGetMovies()
        return UseCaseResult.Success(response)
    }
}