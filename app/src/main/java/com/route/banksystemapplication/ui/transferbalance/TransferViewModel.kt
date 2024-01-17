package com.route.banksystemapplication.ui.transferbalance

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.route.banksystemapplication.repo.AppRepo
import com.route.banksystemapplication.roomdatabase.database.AppDatabase
import com.route.banksystemapplication.roomdatabase.entities.TransferTable

class TransferViewModel(application: Application) : AndroidViewModel(application) {

    private var repo:AppRepo
    init{
        val userDao = AppDatabase.invoke(application).userDao()
        val transDao = AppDatabase.invoke(application).transferDao()
        repo = AppRepo(userDao,transDao)
    }

    fun getData(): LiveData<List<TransferTable>>? {
        return repo.getAllTransfers()
    }

}

class TransferViewModelFactory(private val application : Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TransferViewModel(application) as T
    }
}