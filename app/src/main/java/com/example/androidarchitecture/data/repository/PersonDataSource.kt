package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.model.CreatePostRequest
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.Response
import kotlinx.coroutines.flow.Flow

interface PersonDataSource {

    interface Remote{
        suspend fun getPersons(): List<PersonDbData>
        suspend fun savePerson(person :CreatePostRequest): Response
    }

    interface Local{
        suspend fun getPersons(): List<PersonDbData>
        suspend fun savePersons(personList :List<PersonDbData>)
        suspend fun getAllUser(): Flow<List<PersonDbData>>
        suspend fun getNewPersonId(personId: Int): Flow<PersonDbData?>
    }
}