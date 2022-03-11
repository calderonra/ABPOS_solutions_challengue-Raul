package com.example.abposchallengueraul.client


class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllOrdenes()=retrofitService.getAllOrders()
}