package com.example.androidarchitecture.data.repository

import com.example.androidarchitecture.data.model.User

class UserRepository {
    suspend fun getUsers(): List<User>{
        return listOf(
            User(1, "Polash"),
            User(2, "Premcaitanya"),
            User(3, "Pran"),
            User(4, "Das"),
        )
    }
}