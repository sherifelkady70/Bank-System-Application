package com.route.banksystemapplication.ui.allusers

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.route.banksystemapplication.repo.AppRepo
import com.route.banksystemapplication.roomdatabase.database.AppDatabase
import com.route.banksystemapplication.roomdatabase.entities.UsersTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AllUsersViewModel(application: Application) : AndroidViewModel(application) {

    var repo:AppRepo
    var readAllUsers : LiveData<List<UsersTable>>
    init {
        val userDao=AppDatabase.invoke(application).userDao()
        repo= AppRepo(userDao)


        readAllUsers=repo.getCustomers()!!
    }
    fun addUser(user:List<UsersTable>){
        viewModelScope.launch (Dispatchers.IO){
            repo.addCustomer(user)
        }
    }
}