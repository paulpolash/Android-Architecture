package com.example.androidarchitecture.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidarchitecture.data.model.Users

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(users: List<Users>)

    @Query("SELECT * FROM Users")
    fun getAllUsers():List<Users>
}