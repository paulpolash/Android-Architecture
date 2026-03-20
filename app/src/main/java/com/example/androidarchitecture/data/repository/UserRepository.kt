package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance

class UserRepository(private val apiService: ApiService = RetrofitInstance.api) {
    suspend fun getUsers(): List<User>{
        return apiService.getUsers()
    }
}