package com.touki.moviez.core.features.movies.domain

data class Movie(
    val title: String,
    val year: Int,
    val cover: String,
    val rate: Float,
    val genre: Genre
)