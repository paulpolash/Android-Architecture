package com.example.androidarchitecture.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.repository.UserRepository
import com.example.androidarchitecture.domain.usecase.GetPersonData
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PersonViewModel(private val getPersonData: GetPersonData) : ViewModel() {
//    val personsData: StateFlow<List<PersonDbData>> = personRepository.getNewPersonData()
//        .stateIn(
//            viewModelScope,
//            SharingStarted.WhileSubscribed(5000),
//            emptyList()
//        )

//    fun getPersonById(personId: Int): StateFlow<PersonDbData?> {
//        return personRepository.getNewPersonById(personId)
//            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)
//    }

    fun getPersons() {
        viewModelScope.launch {
            when(val result = getPersonData()){
                is com.example.androidarchitecture.util.Result.Success -> {
                    // update state
                    Log.e("check_data", result.data.toString())
                }

                is com.example.androidarchitecture.util.Result.Error -> {
                    // update error
                }
            }
//            val result = getPersonData()

        }
    }
}