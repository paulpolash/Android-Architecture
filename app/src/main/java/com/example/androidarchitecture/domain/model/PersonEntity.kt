package com.example.androidarchitecture.domain.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.example.androidarchitecture.data.model.Address
import com.example.androidarchitecture.data.model.Company

data class PersonEntity(
    val id: Int,
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
