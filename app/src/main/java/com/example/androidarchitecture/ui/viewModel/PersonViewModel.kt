package com.example.androidarchitecture.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.repository.UserRepository
import com.example.androidarchitecture.domain.model.PersonEntity
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
    private val _personsData = MutableStateFlow<List<PersonEntity>>(emptyList())
    val personsData: StateFlow<List<PersonEntity>> = _personsData
    fun getPersons() {
        viewModelScope.launch {

            _uiState.value = PersonUiState(
                isLoading = true
            )

            when(val result = getPersonData()){
                is com.example.androidarchitecture.util.Result.Success -> {
                    // update state
                    Log.e("check_data", result.data.toString())
                    _personsData.value = result.data
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
    fun getPersonById(id: Int): PersonEntity? {
        return personsData.value.find { it.id == id }
    }
    fun insertPerson(): Response{
        var data = Response("");
        viewModelScope.launch {
            val createPost = CreatePostRequest(
                userId = 1,
                title = "Sample Title",
                body = "Sample Body"
            )
            data = getPersonData.insertPerson(createPost)
        }
        return data
    }
}