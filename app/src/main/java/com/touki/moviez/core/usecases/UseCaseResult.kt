package com.touki.moviez.core.usecases

/** Created by mentok on 2/25/20 */
sealed class UseCaseResult<out T> {
    data class Success<out T>(val data: T) : UseCaseResult<T>()
    data class Failure(val code: String, val message: String) : UseCaseResult<Nothing>()
}