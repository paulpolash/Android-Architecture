package com.example.androidarchitecture.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Person")
data class Person(
    @PrimaryKey val id: Int,
    val name: String,
    val username: String,
    val email: String,
    @Embedded(prefix = "address")
    val address: Address,
    val phone: String,
    val website: String,
    @Embedded(prefix = "company")
    val company: Company,
)
