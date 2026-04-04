package com.example.androidarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance
import com.example.androidarchitecture.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepository(private val dao: UserDao) {
    private val apiService: ApiService = RetrofitInstance.api
    suspend fun getUsers(): List<Person>{
        return apiService.getPersons()
    }
    suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        return apiService.createPost(createPostRequest)
    }

    val users: List<Users> = dao.getAllUsers()
    suspend fun getInsertedData(): List<Users>{
        return users
    }
//    val persons: List<Person> = dao.getAllPerson()
    suspend fun getPersonData(): List<Person>{
        val persons: List<Person> = emptyList()
        return persons
    }
    suspend fun fetchAndSaveUsers(){
        try {
            val apiUsers = RetrofitInstance.api.getPersons()
            dao.insertPersonData(apiUsers)
        } catch (e: Exception) {
            Result.Error(e.message ?: "Unknown error")
        }

    }

    fun getNewPersonData(): Flow<List<Person>> {
        return dao.getAllNewPerson()
    }

    fun getNewPersonById(personId: Int): Flow<Person?> {
        return dao.getAllNewPerson().map { list ->
            list.find { it.id == personId }
        }
    }
}