package com.example.androidarchitecture.domain.usecase

import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.domain.repository.PersonRepository
import com.example.androidarchitecture.util.Result

class GetPersonData(
    private val personRepository: PersonRepository
) {
    suspend operator fun invoke(): Result<List<PersonEntity>> {
        return personRepository.getPersons()
    }
}