package com.route.banksystemapplication.repo

import com.route.banksystemapplication.roomdatabase.dao.TransferDao
import com.route.banksystemapplication.roomdatabase.dao.UserDao
import com.route.banksystemapplication.roomdatabase.entities.TransferTable
import com.route.banksystemapplication.roomdatabase.entities.UsersTable

class AppRepo(private val userDao:UserDao?=null,private val transferDao:TransferDao?=null) {

    fun getCustomers()= userDao?.getAllUsers()
    fun getAllNames() =userDao?.getAllName()
    fun getAllTransfers()=transferDao?.getAllTransfers()

    suspend fun addCustomer(customer:List<UsersTable>)=userDao?.insert(customer)
    suspend fun insertTransaction(trans:TransferTable)=transferDao?.insertTransfers(trans)
    suspend fun getOneCustomer(name:String)=userDao?.getOneUser(name)
    suspend fun updateBalance(user:UsersTable)=userDao?.updateBalance(user)
}