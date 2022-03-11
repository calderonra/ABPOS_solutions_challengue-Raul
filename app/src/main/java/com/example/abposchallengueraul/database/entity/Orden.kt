package com.example.abposchallengueraul.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



data class Orden(
    var id: Int,
    var username: String,
    var subtotal: Double,
    var ticketNumber: Int,
    var orderDateTime:String,
    var orderType:Int

)



