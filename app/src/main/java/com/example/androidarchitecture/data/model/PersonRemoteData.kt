package com.example.androidarchitecture.data.model

import androidx.room.Embedded
import androidx.room.PrimaryKey
import com.example.androidarchitecture.domain.model.PersonEntity

data class PersonRemoteData(
    @PrimaryKey val id: Int,
    val name: String,
    val username: String,
    val email: String,
    @Embedded(prefix = "address")
    val address: Address,
    val phone: String,
    val website: String,
    @Embedded(prefix = "company")
    val company: Company)

fun PersonRemoteData.toDomain()= PersonEntity(
    id = this.id,
    name = this.name,
    username = this.username,
    email = this.email,
    address = this.address,
    phone = this.phone,
    website = this.website,
    company = this.company
)

fun PersonRemoteData.toData()= PersonDbData(
    id = this.id,
    name = this.name,
    username = this.username,
    email = this.email,
    address = this.address,
    phone = this.phone,
    website = this.website,
    company = this.company
)

