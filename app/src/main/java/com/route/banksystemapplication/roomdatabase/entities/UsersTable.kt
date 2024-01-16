package com.route.banksystemapplication.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UsersTable")
data class UsersTable(
    @PrimaryKey(autoGenerate = true)
    val id :Int,
    val name:String,
    val email:String,
    val currentBalance:Int
)
