package com.touki.moviez.dummies

import com.touki.moviez.core.features.movies.domain.Genre
import com.touki.moviez.core.features.movies.domain.Movie

fun apiGetMovies() = listOf(
    Movie(
        title = "Soul",
        year = 2020,
        cover = "https://m.media-amazon.com/images/M/MV5BZGE1MDg5M2MtNTkyZS00MTY5LTg1YzUtZTlhZmM1Y2EwNmFmXkEyXkFqcGdeQXVyNjA3OTI0MDc@._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 8.2f,
        genre = Genre.COMEDY
    ),
    Movie(
        title = "Wonder Woman 1984",
        year = 2020,
        cover = "https://m.media-amazon.com/images/M/MV5BNWY2NWE0NWEtZGUwMC00NWMwLTkyNzUtNmIxMmIyYzA0MjNiXkEyXkFqcGdeQXVyMTA2OTQ3MTUy._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 5.5f,
        genre = Genre.ACTION
    ),
    Movie(
        title = "Shadow in the Cloud",
        year = 2020,
        cover = "https://m.media-amazon.com/images/M/MV5BNWNiNGQyMzUtN2VmMi00NDI2LWI3NGUtMTEwZGQxYzFjZTNjXkEyXkFqcGdeQXVyMTEyNDk3MjY3._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 4.7f,
        genre = Genre.HORROR
    ),
    Movie(
        title = "Avengers: Endgame",
        year = 2019,
        cover = "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 8.4f,
        genre = Genre.ACTION
    ),
    Movie(
        title = "Shadow in the Cloud",
        year = 2020,
        cover = "https://m.media-amazon.com/images/M/MV5BNWNiNGQyMzUtN2VmMi00NDI2LWI3NGUtMTEwZGQxYzFjZTNjXkEyXkFqcGdeQXVyMTEyNDk3MjY3._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 4.7f,
        genre = Genre.HORROR
    ),
    Movie(
        title = "Soul",
        year = 2020,
        cover = "https://m.media-amazon.com/images/M/MV5BZGE1MDg5M2MtNTkyZS00MTY5LTg1YzUtZTlhZmM1Y2EwNmFmXkEyXkFqcGdeQXVyNjA3OTI0MDc@._V1_UX182_CR0,0,182,268_AL_.jpg",
        rate = 8.2f,
        genre = Genre.COMEDY
    ),
)