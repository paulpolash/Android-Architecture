package com.example.androidarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.androidarchitecture.data.local.AppDatabase
import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance
import retrofit2.http.POST

class UserRepository(private val dao: UserDao) {
    private val apiService: ApiService = RetrofitInstance.api
    suspend fun getUsers(): List<User>{
        return apiService.getUsers()
    }
    suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        return apiService.createPost(createPostRequest)
    }

    val users: List<Users> = dao.getAllUsers()
    suspend fun getInsertedData(): List<Users>{
        return users
    }
    suspend fun fetchAndSaveUsers(){
        val apiUsers = RetrofitInstance.api.getUsers()
        val insertData = Users(
            id = 1,
            name = "Premacaitanya",
        )
        val userList = mutableListOf<Users>()
        userList.add(insertData)
        dao.insertUsers(userList)
    }
}