package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.PersonRemoteData
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.util.Result

class PersonRemoteDataSource(
    private val personService: ApiService
): PersonDataSource.Remote {
    override suspend fun getPersons(): Result<List<PersonRemoteData>>  {
        return try {
            val response = personService.getPersons()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    override suspend fun savePerson(person: CreatePostRequest): Response {
        TODO("Not yet implemented")
    }

}