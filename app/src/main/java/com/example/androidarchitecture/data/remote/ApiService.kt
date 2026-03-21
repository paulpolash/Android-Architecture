package com.example.androidarchitecture.data.remote

import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.User
import com.example.androidarchitecture.data.model.Users
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(ApiEndpoints.USERS)
    suspend fun getUsers(): List<User>

    @POST(ApiEndpoints.POST)
    suspend fun createPost(@Body createPost: CreatePostRequest): Response
}