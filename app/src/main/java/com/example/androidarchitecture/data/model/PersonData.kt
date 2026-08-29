package com.example.androidarchitecture.data.model

import com.example.androidarchitecture.domain.model.PersonEntity

data class PersonData(
    val id: Int,
    val name: String,
    val username: String,
    val email: String,
    val address: Address,
    val phone: String,
    val website: String,
    val company: Company
)

fun PersonData.toDomain() = PersonEntity (
    id = this.id,
    name = this.name,
    username = this.username,
    email = this.email,
    address = this.address,
    phone = this.phone,
    website = this.website,
    company = this.company,
)

fun PersonEntity.toData() = PersonEntity(
    id = this.id,
    name = this.name,
    username = this.username,
    email = this.email,
    address = this.address,
    phone = this.phone,
    website = this.website,
    company = this.company
)

