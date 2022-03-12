package com.example.abposchallengueraul.activities

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.abposchallengueraul.R

class OrdenesDetalleActivity : AppCompatActivity() {

    private lateinit var orderID_tv: TextView
    private lateinit var username_tv: TextView
    private lateinit var subtotal_tv: TextView
    private lateinit var ticketnumber_tv: TextView
    private lateinit var orderDateTime_tv: TextView
    private lateinit var orderType_tv: TextView


    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordenes_detalle)
        sharedPreferences= getSharedPreferences("MySP", MODE_PRIVATE)

        orderID_tv=findViewById(R.id.orderTV)
        username_tv=findViewById(R.id.userTV)
        subtotal_tv=findViewById(R.id.totalTV)
        ticketnumber_tv=findViewById(R.id.ticketTV)
        orderDateTime_tv=findViewById(R.id.orderTimeTV)
        orderType_tv=findViewById(R.id.orderTypeTV)



        orderID_tv.text=sharedPreferences.getInt("orderID",0).toString()
        username_tv.text=sharedPreferences.getString("username","n/a")
        subtotal_tv.text=sharedPreferences.getFloat("subtotal",0.0f).toString()
        ticketnumber_tv.text=sharedPreferences.getInt("ticketNumber",0).toString()
        orderDateTime_tv.text=sharedPreferences.getString("orderDateTime","n/a")
        orderType_tv.text=sharedPreferences.getInt("orderType",0).toString()





    }

}