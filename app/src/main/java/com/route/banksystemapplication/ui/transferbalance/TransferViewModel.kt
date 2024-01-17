package com.route.banksystemapplication.ui.transferbalance

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class TransferViewModel(application: Application) : AndroidViewModel(application) {


}

class TransferViewModelFactory(private val application : Application) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TransferViewModel(application) as T
    }
}