package com.route.banksystemapplication.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Update
import com.route.banksystemapplication.roomdatabase.entities.UsersTable

@Dao
interface UserDao {
  @Insert
  fun insert(user:List<UsersTable>)
  @Query("SELECT * FROM UsersTable")
  fun getAllUsers():LiveData<List<UsersTable>>
  @Query("SELECT name FROM UsersTable")
  fun getAllName():LiveData<List<String>>
  @Query("SELECT * FROM UsersTable WHERE name=:uName")
  suspend fun getOneUser(uName:String):UsersTable
  @Update
  suspend fun updateBalance(user:UsersTable)
}