package com.example.abposchallengueraul.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.abposchallengueraul.client.MainRepository
import com.example.abposchallengueraul.database.entity.Orden
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel constructor(private val repository: MainRepository):ViewModel() {
    val ordenesList=MutableLiveData<List<Orden>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllOrdenes(){

        val response=repository.getAllOrdenes()
        response.enqueue(object : Callback<List<Orden>>{
            override fun onResponse(call: Call<List<Orden>>, response: Response<List<Orden>>) {
                ordenesList.postValue(response.body())

            }

            override fun onFailure(call: Call<List<Orden>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })

    }

}