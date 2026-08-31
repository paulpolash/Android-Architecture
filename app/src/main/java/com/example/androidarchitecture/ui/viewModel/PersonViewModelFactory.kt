package com.example.androidarchitecture.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.data.repository.UserRepository
import com.example.androidarchitecture.domain.usecase.GetPersonData

class PersonViewModelFactory(
    private val getPersonData: GetPersonData
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonViewModel(getPersonData) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}