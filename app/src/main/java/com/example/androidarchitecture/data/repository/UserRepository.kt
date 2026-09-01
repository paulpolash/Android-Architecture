package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.local.PersonDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.PersonRemoteData
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance

class UserRepository(private val dao: PersonDao) {
    private val apiService: ApiService = RetrofitInstance.api
    suspend fun getUsers(): List<PersonRemoteData>{
        return apiService.getPersons()
    }
    suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        return apiService.createPost(createPostRequest)
    }

//    val users: List<Users> = dao.getAllUsers()
//    suspend fun getInsertedData(): List<Users>{
//        return users
//    }
//    val persons: List<Person> = dao.getAllPerson()
    suspend fun getPersonData(): List<PersonDbData>{
        val persons: List<PersonDbData> = emptyList()
        return persons
    }
    suspend fun fetchAndSaveUsers(){
        try {
            val apiUsers = RetrofitInstance.api.getPersons()
//            dao.insertPersonData(apiUsers)
        } catch (e: Exception) {
//            Result.Error(e)
        }
    }

    fun getNewPersonData(): List<PersonDbData> {
        return dao.getAllNewPerson()
    }

//    fun getNewPersonById(personId: Int): PersonDbData {
//        return dao.getAllNewPerson().map { list ->
//            list.find { it.id == personId }
//        }
//    }
}