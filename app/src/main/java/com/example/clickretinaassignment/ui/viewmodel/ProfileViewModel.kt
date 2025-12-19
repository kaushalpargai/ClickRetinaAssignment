package com.example.clickretinaassignment.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickretinaassignment.data.model.UserProfile
import com.example.clickretinaassignment.data.repository.ProfileRepository
import com.example.clickretinaassignment.data.repository.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ProfileUiState {
    object Loading : ProfileUiState()
    data class Success(val profile: UserProfile, val fromApi: Boolean) : ProfileUiState()
    data class Error(val message: String) : ProfileUiState()
}

class ProfileViewModel(
    private val repository: ProfileRepository = ProfileRepository()
) : ViewModel() {
    
    private val _uiState = MutableStateFlow<ProfileUiState>(ProfileUiState.Loading)
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()
    
    init {
        loadProfile()
    }
    
    fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = ProfileUiState.Loading
            
            when (val result = repository.getProfile()) {
                is Result.Success -> {
                    _uiState.value = ProfileUiState.Success(result.data, result.fromApi)
                }
                is Result.Error -> {
                    _uiState.value = ProfileUiState.Error(result.message)
                }
            }
        }
    }
    
    fun retry() {
        loadProfile()
    }
}
