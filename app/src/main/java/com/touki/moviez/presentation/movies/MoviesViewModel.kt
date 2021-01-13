package com.touki.moviez.presentation.movies

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.touki.moviez.core.Interactors
import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.core.usecases.UseCaseResult
import kotlinx.coroutines.launch

class MoviesViewModel @ViewModelInject constructor(
    private val interactors: Interactors
): ViewModel() {
    private val _getMoviesSuccess = MutableLiveData<List<Movie>>()
    val getMoviesSuccess: LiveData<List<Movie>> = _getMoviesSuccess

    private val _getMoviesFailure = MutableLiveData<String>()
    val getMoviesFailure: LiveData<String> = _getMoviesFailure

    fun getMovies() {
        viewModelScope.launch {
            when (val response = interactors.getMovies()) {
                is UseCaseResult.Success -> _getMoviesSuccess.value = response.data
                is UseCaseResult.Failure -> _getMoviesFailure.value = response.message
            }
        }
    }
}