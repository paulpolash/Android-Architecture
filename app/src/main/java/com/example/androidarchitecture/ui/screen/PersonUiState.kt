package com.example.androidarchitecture.ui.screen

import com.example.androidarchitecture.domain.model.PersonEntity

data class PersonUiState(
    val isLoading: Boolean = false,
    val persons: List<PersonEntity> = emptyList(),
    val error: String? = null
)
