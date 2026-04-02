package com.example.androidarchitecture.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.androidarchitecture.data.repository.UserRepository

class PersonViewModelFactory(
    private val personRepository: UserRepository
) : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonViewModel(personRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}