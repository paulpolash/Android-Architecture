package com.example.androidarchitecture.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.repository.UserRepository
import com.example.androidarchitecture.domain.usecase.GetPersonData
import com.example.androidarchitecture.ui.screen.PersonUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PersonViewModel(private val getPersonData: GetPersonData) : ViewModel() {
    private val _uiState = MutableStateFlow(PersonUiState())
    val uiState: StateFlow<PersonUiState> = _uiState
    fun getPersons() {
        viewModelScope.launch {

            _uiState.value = PersonUiState(
                isLoading = true
            )

            when(val result = getPersonData()){
                is com.example.androidarchitecture.util.Result.Success -> {
                    // update state
                    Log.e("check_data", result.data.toString())
                    _uiState.value = PersonUiState(
                        persons = result.data
                    )
                }

                is com.example.androidarchitecture.util.Result.Error -> {
                    // update error
                    _uiState.value = PersonUiState(
                        error = result.error.message
                    )
                }
            }
//            val result = getPersonData()

        }
    }
}