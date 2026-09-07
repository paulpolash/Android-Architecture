package com.example.androidarchitecture.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.domain.usecase.GetPersonData
import com.example.androidarchitecture.ui.screen.PersonUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PersonViewModel @Inject constructor (private val getPersonData: GetPersonData) : ViewModel() {
    private val _uiState = MutableStateFlow(PersonUiState())
    val uiState: StateFlow<PersonUiState> = _uiState
    private val _personsData = MutableStateFlow<List<PersonEntity>>(emptyList())
    val personsData: StateFlow<List<PersonEntity>> = _personsData
    fun getPersons() {
        viewModelScope.launch(Dispatchers.IO) {

            _uiState.value = PersonUiState(
                isLoading = true
            )

            when(val result = getPersonData()){
                is com.example.androidarchitecture.util.Result.Success -> {
                    // update state
                    withContext(Dispatchers.Main) {
                        Log.e("check_data", result.data.toString())
                        _personsData.value = result.data
                        _uiState.value = PersonUiState(
                            persons = result.data
                        )
                    }
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
    fun insertPerson(){
        var data = Response("");
        viewModelScope.launch(Dispatchers.IO) {
            val createPost = CreatePostRequest(
                userId = 1,
                title = "Sample Title",
                body = "Sample Body"
            )
            data = getPersonData.insertPerson(createPost)
            Log.e("check_data",data.toString())
        }
    }
}