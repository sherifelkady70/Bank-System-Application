package com.route.banksystemapplication.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TransferTable" )
data class TransferTable(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val sender:String,
    val receiver:String,
    val amount : Int
)
