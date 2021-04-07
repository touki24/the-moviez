package com.touki.moviez.presentation.movies

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.touki.moviez.R
import com.touki.moviez.databinding.ActivityMovieBinding
import com.touki.moviez.presentation.movies.adapter.MoviesRecyclerAdapter
import com.touki.moviez.presentation.settings.SettingsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMovieBinding
    private val moviesViewModel: MoviesViewModel by viewModels()
    private val adapter by lazy { MoviesRecyclerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        initiateView()
        setMoviesObserver()

        moviesViewModel.getMovies()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movies_overflow_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_movies_setting) {
            val newIntent = Intent(this, SettingsActivity::class.java)
            startActivity(newIntent)
        }
        return true
    }

    private fun initiateView() {
        with(viewBinding) {
            progressBarMovies.visibility = View.VISIBLE
            recyclerMovies.layoutManager = LinearLayoutManager(this@MoviesActivity)
            recyclerMovies.itemAnimator = DefaultItemAnimator()
            recyclerMovies.adapter = adapter
        }
    }

    private fun setMoviesObserver() {
        moviesViewModel.getMoviesSuccess.observe(this) {
            adapter.setMovies(it)
            viewBinding.progressBarMovies.visibility = View.GONE
        }

        moviesViewModel.getMoviesFailure.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            viewBinding.progressBarMovies.visibility = View.GONE
        }
    }
}