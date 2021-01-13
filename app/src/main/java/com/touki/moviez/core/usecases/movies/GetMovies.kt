package com.touki.moviez.core.usecases.movies

import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.core.features.movies.repository.MoviesRepository
import com.touki.moviez.core.usecases.UseCaseResult

class GetMovies(private val moviesRepository: MoviesRepository) {
    suspend operator fun invoke() : UseCaseResult<List<Movie>> {
        return moviesRepository.getMovies()
    }
}