package com.touki.moviez.presentation.auth

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.touki.moviez.core.Interactors
import com.touki.moviez.core.features.auth.domain.AuthParams
import com.touki.moviez.core.features.auth.domain.UserInfo
import com.touki.moviez.core.features.auth.domain.UserPass
import com.touki.moviez.core.usecases.UseCaseResult
import kotlinx.coroutines.launch

/** Created by mentok on 4/7/21 */
class AuthViewModel @ViewModelInject constructor(
    private val interactors: Interactors
): ViewModel() {
    private val _signInByUserPassSuccess : MutableLiveData<UserInfo> = MutableLiveData()
    val signInByUserPassSuccess : LiveData<UserInfo> = _signInByUserPassSuccess

    private val _signInByUserPassFailure : MutableLiveData<String> = MutableLiveData()
    val signInByUserPassFailure : LiveData<String> = _signInByUserPassFailure

    private val _validateUserPassSuccess : MutableLiveData<UserPass> = MutableLiveData()
    val validateUserPassSuccess : LiveData<UserPass> = _validateUserPassSuccess

    private val _validateUserFailure : MutableLiveData<String> = MutableLiveData()
    val validateUserFailure : LiveData<String> = _validateUserFailure

    private val _validatePassFailure : MutableLiveData<String> = MutableLiveData()
    val validatePassFailure : LiveData<String> = _validatePassFailure

    fun signInByUserPass(userPass: UserPass) {
        viewModelScope.launch {
            when (val response = interactors.signInByUserPass(userPass)) {
                is UseCaseResult.Success -> _signInByUserPassSuccess.value = response.data
                is UseCaseResult.Failure -> _signInByUserPassFailure.value = response.message
            }
        }
    }

    fun validateUserPass(username: String, password: String) {
        when (val response = interactors.validateUserPass(UserPass(username, password))) {
            is UseCaseResult.Success -> _validateUserPassSuccess.value = response.data
            is UseCaseResult.Failure -> {
                if (response.code.toInt() < 200 ) {
                    _validateUserFailure.value = response.message
                } else {
                    _validatePassFailure.value = response.message
                }
            }
        }
    }
}