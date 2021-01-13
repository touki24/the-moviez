package com.touki.moviez.presentation.settings

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.touki.moviez.core.Interactors
import com.touki.moviez.core.usecases.UseCaseResult
import kotlinx.coroutines.launch

class SettingsViewModel @ViewModelInject constructor(
    private val interactors: Interactors
): ViewModel() {

    private val _darkThemeEnabledSuccess = MutableLiveData<Boolean>()
    val darkThemeEnabledSuccess: LiveData<Boolean> = _darkThemeEnabledSuccess

    private val _darkThemeEnabledFailure = MutableLiveData<String>()
    val darkThemeEnabledFailure: LiveData<String> = _darkThemeEnabledFailure

    init {
        _darkThemeEnabledSuccess.value = interactors.getDarkTheme()
    }

    fun isDarkThemeEnabled() : Boolean {
        return interactors.getDarkTheme()
    }

    fun toggleDarkTheme(enabled: Boolean) {
        viewModelScope.launch {
            when (val response = interactors.setDarkTheme(enabled)) {
                is UseCaseResult.Success -> _darkThemeEnabledSuccess.value = response.data.enabled
                is UseCaseResult.Failure -> _darkThemeEnabledFailure.value = response.message
            }
        }
    }
}