package com.example.androidarchitecture.data.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.androidarchitecture.domain.model.PersonEntity

@Entity(tableName = "Person")
data class PersonDbData(
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
fun PersonDbData.toDomain()= PersonEntity (
    id = this.id,
    name = this.name,
    username = this.username,
    email = this.email,
    address = this.address,
    phone = this.phone,
    website = this.website,
    company = this.company,
)
