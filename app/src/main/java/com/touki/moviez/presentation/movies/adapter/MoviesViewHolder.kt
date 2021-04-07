package com.touki.moviez.presentation.movies.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.touki.moviez.R
import com.touki.moviez.core.features.movies.domain.Genre
import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.databinding.ItemMovieBadBinding
import com.touki.moviez.databinding.ItemMovieBinding
import com.touki.moviez.framework.common.extensions.toIdr
class MoviesViewHolder(private val viewBinding: ItemMovieBinding): RecyclerView.ViewHolder(viewBinding.root) {
//class MoviesViewHolder(private val viewBinding: ItemMovieBadBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(movie: Movie) {
        with(viewBinding) {
            val context = viewBinding.root.context

            textTitle.text = context.getString(R.string.info_movie_title, movie.title, movie.year)

            textRating.text = movie.rate.toString()

            val genre = when (movie.genre) {
                Genre.ACTION -> context.getString(R.string.label_action)
                Genre.HORROR -> context.getString(R.string.label_horror)
                Genre.COMEDY -> context.getString(R.string.label_comedy)
            }

            textGenre.text = genre

            textPrice.text = movie.price.toIdr()

            imageCover.load(movie.cover)
        }
    }
}