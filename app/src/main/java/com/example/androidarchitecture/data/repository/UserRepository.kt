package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Person
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance

class UserRepository(private val dao: UserDao) {
    private val apiService: ApiService = RetrofitInstance.api
    suspend fun getUsers(): List<Person>{
        return apiService.getPersons()
    }
    suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        return apiService.createPost(createPostRequest)
    }

    val users: List<Users> = dao.getAllUsers()
    val persons: List<Person> = dao.getAllPerson()
    suspend fun getInsertedData(): List<Users>{
        return users
    }
    suspend fun getPersonData(): List<Person>{
        return persons
    }
    suspend fun fetchAndSaveUsers(){
        val apiUsers = RetrofitInstance.api.getPersons()
        val insertData = Users(
            id = 1,
            name = "Premacaitanya",
        )
//        val userList = mutableListOf<Users>()
//        val personList = List<Person>()
//        userList.add(insertData)
//        personList.add(apiUsers)
//        dao.insertUsers(userList)
        dao.insertPersonData(apiUsers)
    }
}