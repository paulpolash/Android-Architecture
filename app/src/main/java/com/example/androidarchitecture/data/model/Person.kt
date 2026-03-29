package com.example.androidarchitecture.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class Person(
    @PrimaryKey val id: Int,
    val name: String,
    val username: String,
    val age: Int
)
