package com.route.banksystemapplication.roomdatabase.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.route.banksystemapplication.roomdatabase.entities.TransferTable

@Dao
interface TransferDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransfers(vararg tansfers:TransferTable)
    @Query("SELECT * FROM TransferTable")
    fun getAllTransfers():LiveData<List<TransferTable>>
}