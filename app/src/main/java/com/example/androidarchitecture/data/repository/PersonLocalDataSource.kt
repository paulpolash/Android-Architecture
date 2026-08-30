package com.example.androidarchitecture.data.repository

import android.ranging.DataNotificationConfig
import com.example.androidarchitecture.data.local.UserDao
import com.example.androidarchitecture.data.model.PersonDbData
import com.example.androidarchitecture.data.model.PersonRemoteData
import com.example.androidarchitecture.data.model.toData
import com.example.androidarchitecture.data.model.toDomain
import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.util.Result
import com.example.androidarchitecture.util.map
import kotlinx.coroutines.flow.Flow

class PersonLocalDataSource(
    private val personDao: UserDao
): PersonDataSource.Local {
    override suspend fun getPersons(): Result<List<PersonEntity>> {
        val persons = personDao.getAllNewPerson()
        return (if (persons.isNotEmpty()) {
            Result.Success(persons.map { it.toDomain() })
        } else {
            Result.Error(Exception("Data not available"))
        })
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