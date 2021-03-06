package com.example.abposchallengueraul.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.abposchallengueraul.client.MainRepository

class MyViewModelFactory(private val repository: MainRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            MainViewModel(this.repository)as T
        }else{
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}