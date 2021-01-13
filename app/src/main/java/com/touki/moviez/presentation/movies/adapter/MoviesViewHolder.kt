package com.touki.moviez.presentation.movies.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.touki.moviez.R
import com.touki.moviez.core.features.movies.domain.Genre
import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.databinding.ItemMovieBinding

class MoviesViewHolder(private val viewBinding: ItemMovieBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(movie: Movie) {
        with(viewBinding) {
            val context = viewBinding.root.context

            itemMovieTitle.text = context.getString(R.string.info_movie_title, movie.title, movie.year)

            itemMovieRating.text = context.getString(R.string.info_rating, movie.rate)

            val genre = when (movie.genre) {
                Genre.ACTION -> context.getString(R.string.label_action)
                Genre.HORROR -> context.getString(R.string.label_horror)
                Genre.COMEDY -> context.getString(R.string.label_comedy)
            }

            itemMovieGenre.text = context.getString(R.string.info_genre, genre)

            itemMovieImageCover.load(movie.cover)
        }
    }
}