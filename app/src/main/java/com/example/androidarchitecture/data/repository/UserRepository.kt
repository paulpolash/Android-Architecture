package com.example.androidarchitecture.data.repository

import androidx.lifecycle.LiveData
import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance
import retrofit2.http.POST

class UserRepository(private val apiService: ApiService = RetrofitInstance.api, private val dao: UserDao) {
    suspend fun getUsers(): List<User>{
        return apiService.getUsers()
    }
    suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        return apiService.createPost(createPostRequest)
    }

    val users: LiveData<List<Users>> = dao.getAllUsers()

    suspend fun fetchAndSaveUsers(){
        val apiUsers = RetrofitInstance.api.getUsers()
//        dao.insertUsers(apiUsers)
    }
}