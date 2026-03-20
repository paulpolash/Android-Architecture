package com.example.androidarchitecture.data.remote

import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import retrofit2.http.GET

interface ApiService {
    @GET(ApiEndpoints.USERS)
    suspend fun getUsers(): List<User>
}