package com.route.banksystemapplication.roomdatabase.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.route.banksystemapplication.roomdatabase.DummyData
import com.route.banksystemapplication.roomdatabase.dao.TransferDao
import com.route.banksystemapplication.roomdatabase.dao.UserDao
import com.route.banksystemapplication.roomdatabase.entities.TransferTable
import com.route.banksystemapplication.roomdatabase.entities.UsersTable
import java.lang.Exception
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.locks.Lock

@Database(entities = [UsersTable::class,TransferTable::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao():UserDao
    abstract fun transferDao():TransferDao



    companion object{
        @Volatile
        private var Instance : AppDatabase?=null
        private val Lock =Any()

        operator fun invoke(context: Context) = Instance ?: synchronized(Lock) {
            Instance ?: createDatabase(context).also {
                Instance = it
            }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "bankDatabase"
        ).addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                Executors.newSingleThreadExecutor().execute {
                    try {
                        Instance?.userDao()?.insert(user = DummyData.getDummyData())
//                        val data = DummyData.getDummyData()
//                        data.forEach {  user ->
//                            Log.d("AppDatabase","data : $user")
//                        }
                    }
                    catch (e:Exception){
                        e.printStackTrace()
                    }
                }
            }
        }).fallbackToDestructiveMigration()
            .build()
    }
}