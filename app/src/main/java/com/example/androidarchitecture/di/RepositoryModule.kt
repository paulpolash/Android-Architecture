package com.example.androidarchitecture.di

import com.example.androidarchitecture.data.repository.PersonRepositoryIml
import com.example.androidarchitecture.domain.repository.PersonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPersonRepository(
        personRepositoryImpl: PersonRepositoryIml
    ): PersonRepository
}
