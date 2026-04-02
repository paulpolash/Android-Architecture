package com.example.androidarchitecture.ui.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidarchitecture.data.local.AppDatabase
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel(application: Application): AndroidViewModel(application) {
    private val userRepository by lazy {
        UserRepository(
            dao = AppDatabase.getDatabase(application).userDao()
        )
    }
//    private val userRepository= UserRepository(
//        dao = AppDatabase.getDatabase(application).userDao()
//    )
    private val _users = MutableLiveData<List<Person>>()
    val users : LiveData<List<Person>> = _users

    fun fetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            val result = userRepository.getUsers()
            withContext(Dispatchers.Main){
                _users.value = result
            }
        }
    }
    private val allUsers = MutableLiveData<List<Users>>()
    val getUsers : LiveData<List<Users>> = allUsers

    private val allPerson = MutableLiveData<List<Person>>()
    val personsData : LiveData<List<Person>> = allPerson
    fun insertAndFetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            try{
                userRepository.fetchAndSaveUsers()
//                val data = userRepository.getPersonData()
//                withContext(Dispatchers.Main) {
//                    allPerson.value = data
//                }
            }catch (e: Exception){
                Log.e("API_ERROR", e.message.toString())

        }
        }
    }
    fun getPersonById(personId: Int): Person ?{
        return personsData.value?.find { it.id == personId }
    }

    fun createPost(){
        viewModelScope.launch(Dispatchers.IO) {
            val createPost = CreatePostRequest(
                userId = 1,
                title = "Sample Title",
                body = "Sample Body"
            )
            val result = userRepository.createPost(createPost)

            withContext(Dispatchers.Main){
                Log.d("Post", result.toString())
            }
        }
    }
}