package com.example.androidarchitecture.data.repository

import android.util.Log
import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.Response
import com.example.androidarchitecture.data.model.toDomain
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.domain.repository.PersonRepository
import com.example.androidarchitecture.util.Result

class PersonRepositoryIml(
    private val localDataSource: PersonLocalDataSource,
    private val remoteDataSource: PersonRemoteDataSource
): PersonRepository {
    override suspend fun getPersons(): Result<List<PersonEntity>> {
        //check local first
        return when (val localResult = localDataSource.getPersons()) {
            is Result.Success ->{
                localResult
            }
            is Result.Error -> {
                //local is empty call remote and save to local
                when (val remoteResult = remoteDataSource.getPersons()) {
                    is Result.Success -> {
                        //save to local
                        localDataSource.savePersons(remoteResult.data.map { it.toDomain() })
                        //read again from local
                        localDataSource.getPersons()
                    }
                    is Result.Error -> {
                        remoteResult
                    }

                }
            }
            else -> {
                Log.d("TAG", "Unknown error")
            }
        } as Result<List<PersonEntity>>

    }
    override suspend fun createPost(createPostRequest: CreatePostRequest): Response {
        TODO("Not yet implemented")
    }
}