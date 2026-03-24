package com.example.androidarchitecture.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users(
    @PrimaryKey val id: Int,
    val name: String
){

}
