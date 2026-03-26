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
    private val _users = MutableLiveData<List<User>>()
    val users : LiveData<List<User>> = _users

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
    fun insertAndFetchData(){
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.fetchAndSaveUsers()
            val data = userRepository.getInsertedData()
            withContext(Dispatchers.Main) {
                allUsers.value = data
            }
        }
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