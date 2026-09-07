package com.example.androidarchitecture.di

import com.example.androidarchitecture.data.remote.ApiService
import com.example.androidarchitecture.data.remote.RetrofitInstance
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import dagger.Provides
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return RetrofitInstance.api
    }
}