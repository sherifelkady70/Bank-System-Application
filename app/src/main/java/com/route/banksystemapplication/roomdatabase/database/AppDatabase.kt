package com.route.banksystemapplication.roomdatabase.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.route.banksystemapplication.roomdatabase.DummyData
import com.route.banksystemapplication.roomdatabase.dao.TransferDao
import com.route.banksystemapplication.roomdatabase.dao.UserDao
import com.route.banksystemapplication.roomdatabase.entities.TransferTable
import com.route.banksystemapplication.roomdatabase.entities.UsersTable
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Database(entities = [UsersTable::class,TransferTable::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao():UserDao
    abstract fun transferDao():TransferDao



    companion object{
        @Volatile
        private var instance : AppDatabase?=null
        private val lock =Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: createDatabase(context).also {
                instance=it
            }
        }



        fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "bankDatabase"
        ).addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                Executors.newSingleThreadExecutor().execute {
                    instance.let {
                        if (it != null) {
                            it.userDao().insert(user = DummyData.getDummyData())
                        }
                    }
                }
            }
        }).build()
    }
}