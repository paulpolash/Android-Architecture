package com.example.androidarchitecture.data.remote

import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET(ApiEndpoints.USERS)
    suspend fun getPersons(): List<PersonDbData>

    @POST(ApiEndpoints.POST)
    suspend fun createPost(@Body createPost: CreatePostRequest): Response

}