package com.example.androidarchitecture.domain.usecase

import com.example.androidarchitecture.domain.model.PersonEntity
import com.example.androidarchitecture.domain.repository.PersonRepository

class GetPersonDtata(
    private val personRepository: PersonRepository
) {
    suspend operator fun invoke(): List<PersonEntity> {
        return personRepository.getPersons() as List<PersonEntity>
    }
}