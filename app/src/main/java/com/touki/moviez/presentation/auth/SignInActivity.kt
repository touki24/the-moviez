package com.touki.moviez.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.snackbar.Snackbar
import com.touki.moviez.databinding.ActivitySignInBinding
import com.touki.moviez.presentation.movies.MoviesActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignInActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivitySignInBinding
    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        setOnClick()
        setValidateUserPassObserver()
        setSignInByUserPassObserver()
    }

    private fun setOnClick() {
        with(viewBinding) {
            buttonSignIn.setOnClickListener {
                viewBinding.textInputLayoutUsername.error = null
                viewBinding.textInputLayoutPassword.error = null

                val username = viewBinding.editTextUsername.text?.toString() ?: ""
                val password = viewBinding.editTextPassword.text?.toString() ?: ""

                authViewModel.validateUserPass(username, password)
            }
        }
    }

    private fun setSignInByUserPassObserver() {
        authViewModel.signInByUserPassSuccess.observe(this) {
            val newIntent = Intent(this, MoviesActivity::class.java)
            startActivity(newIntent)
            finish()
        }

        authViewModel.signInByUserPassFailure.observe(this) {
            Snackbar.make(viewBinding.root, it, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setValidateUserPassObserver() {
        authViewModel.validateUserPassSuccess.observe(this) {
            authViewModel.signInByUserPass(it)
        }

        authViewModel.validateUserFailure.observe(this) {
            viewBinding.textInputLayoutUsername.error = it
        }

        authViewModel.validatePassFailure.observe(this) {
            viewBinding.textInputLayoutPassword.error = it
        }
    }
}