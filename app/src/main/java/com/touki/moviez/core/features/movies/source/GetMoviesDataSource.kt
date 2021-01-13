package com.touki.moviez.core.features.movies.source

import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.core.usecases.UseCaseResult

interface GetMoviesDataSource {
    suspend operator fun invoke() : UseCaseResult<List<Movie>>
}