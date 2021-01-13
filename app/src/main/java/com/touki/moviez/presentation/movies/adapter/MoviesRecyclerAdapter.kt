package com.touki.moviez.presentation.movies.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.touki.moviez.core.features.movies.domain.Movie
import com.touki.moviez.databinding.ItemMovieBinding

class MoviesRecyclerAdapter: RecyclerView.Adapter<MoviesViewHolder>() {

    private val movieList = mutableListOf<Movie>()

    fun setMovies(movies: List<Movie>) {
        this.movieList.clear()
        this.movieList.addAll(movies)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        return MoviesViewHolder(ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size
}