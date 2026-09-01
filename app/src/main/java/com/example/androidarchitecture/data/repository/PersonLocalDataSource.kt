package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.local.PersonDao
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.toData
import com.example.androidarchitecture.data.model.toDomain
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class PersonLocalDataSource(
    private val personDao: PersonDao
): PersonDataSource.Local {
    override suspend fun getPersons(): Result<List<PersonEntity>> {
        return withContext(Dispatchers.IO) {
            val persons = personDao.getAllNewPerson()
            (if (persons.isNotEmpty()) {
                Result.Success(persons.map { it.toDomain() })
            } else {
                Result.Error(Exception("Data not available"))
            })
        }
    }

    override suspend fun savePersons(personList: List<PersonEntity>) {
        personDao.insertPersonData(
            personList.map { it.toData() }
        )
    }

    override suspend fun getAllUser(): Flow<List<PersonDbData>> {
        TODO("Not yet implemented")
    }

    override suspend fun getNewPersonId(personId: Int): Flow<PersonDbData?> {
        TODO("Not yet implemented")
    }

}