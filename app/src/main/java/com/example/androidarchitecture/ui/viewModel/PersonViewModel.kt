package com.example.androidarchitecture.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.data.repository.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class PersonViewModel(private val personRepository: UserRepository) : ViewModel() {
    val personsData: StateFlow<List<Person>> = personRepository.getNewPersonData()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun getPersonById(personId: Int): StateFlow<Person?> {
        return personRepository.getNewPersonById(personId)
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)
    }
}