package com.example.androidarchitecture.domain.repository

import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.util.Result

interface PersonRepository {
    suspend fun getPersons(): Result<List<PersonEntity>>
    suspend fun getPersonById(id: Int): Result<PersonEntity>
    suspend fun createPost(createPostRequest: CreatePostRequest): Response
}