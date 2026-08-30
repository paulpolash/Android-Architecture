package com.example.androidarchitecture.data.repository

import android.util.Log
import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.toDomain
import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.domain.repository.PersonRepository
import com.example.androidarchitecture.util.Result
import com.example.androidarchitecture.util.Result.Success

class PersonRepositoryIml(
    private val dao: UserDao,
    private val apiService: ApiService,
    private val localDataSource: PersonLocalDataSource,
): PersonRepository {
    override suspend fun getPersons(): Result<List<PersonEntity>> {
        return when (val localResult = localDataSource.getPersons()) {
            is Result.Success ->{
                localResult
            }
            is Error -> apiService.getPersons().map { it.toDomain() }
            else -> {
//                Result.Error(Exception("Unknown error"))
                Log.d("TAG", "Unknown error")
            }
        } as Result<List<PersonEntity>>

    }
    override suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        TODO("Not yet implemented")
    }
}