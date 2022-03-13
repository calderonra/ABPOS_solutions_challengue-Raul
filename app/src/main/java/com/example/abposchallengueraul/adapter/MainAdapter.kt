package com.example.abposchallengueraul.adapter

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.abposchallengueraul.activities.OrdenesDetalleActivity
import com.example.abposchallengueraul.database.entity.Orden
import com.example.abposchallengueraul.databinding.OrdenesAdapterBinding
import java.util.*
import kotlin.collections.ArrayList

open class MainAdapter(val context: Context, var ordenes: MutableList<Orden>, var ordenesBackup: MutableList<Orden>):RecyclerView.Adapter<MainAdapter.MainViewHolder> (){

    lateinit var sharedPreferences: SharedPreferences
    var ordenesFiltered = ArrayList<Orden>()

    fun setOrdenesList(ordenes:List<Orden>){
        this.ordenes=ordenes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding: OrdenesAdapterBinding =
            OrdenesAdapterBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        sharedPreferences=context.getSharedPreferences("MySP", Activity.MODE_PRIVATE)

        return MainViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(ordenes[position])
    }

    override fun getItemCount(): Int {
        return ordenes.size
    }

    inner class MainViewHolder(val binding: OrdenesAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(ordenes: Orden){

            binding.root.setOnClickListener{
                val editor=sharedPreferences.edit()
                editor.putInt("orderID",ordenes.orderId)
                editor.putString("username",ordenes.username)
                editor.putFloat("subtotal",ordenes.subtotal.toFloat())
                editor.putInt("ticketNumber",ordenes.ticketNumber)
                editor.putString("orderDateTime",ordenes.orderDateTime)
                editor.putInt("orderType",ordenes.orderType)
                editor.apply()
                val intent=Intent(context,OrdenesDetalleActivity::class.java)
                context.startActivity(intent)

            }
            binding.orderTV.text=ordenes.orderId.toString()
            binding.ticketTV.text=ordenes.ticketNumber.toString()
            binding.PickUpTV.text=ordenes.orderType.toString()
            binding.orderTimeTV.text=ordenes.orderDateTime

        }
}


   fun filter(textAux: String) {
      var text = textAux
      text = text
      if(text.length == 1){
          ordenesFiltered.clear()
          ordenesFiltered.addAll(ordenesBackup)
      }
      ordenes.clear()
      if (text.isEmpty()) {
          Log.e("filter", "esta vacio ves")
          ordenes.addAll(ordenesBackup)
      } else{
          Log.e("filter", "avr buscando")
          for (item in ordenesFiltered) {
              if (item.orderId.toString().lowercase(Locale.getDefault()).contains(text)) {
                  ordenes.add(item)
              }
          }
      }
      notifyDataSetChanged()
  }



    fun DineINfilter() {
        val text = "1"
        ordenes.clear()
        if (text.isEmpty()) {
            ordenes.addAll(ordenesFiltered)
        } else {
            for (item in ordenesFiltered) {
                if (item.orderType.toString().contains(text)) {
                    ordenes.add(item)
                    //Log.d(TAG, "pasty")

                }
            }
        }
        notifyDataSetChanged()
    }

    fun TogoFilter() {
        val text = "2"
        ordenes.clear()
        if (text.isEmpty()) {
            ordenes.addAll(ordenesFiltered)
        } else {
            for (item in ordenesFiltered) {
                if (item.orderType.toString().contains(text)) {
                    ordenes.add(item)
                //Log.d(TAG, "pasty")

                }
            }
        }
        notifyDataSetChanged()
    }

    fun PickUPfilter() {
        val text = "3"
        ordenes.clear()
        if (text.isEmpty()) {
            ordenes.addAll(ordenesFiltered)
        } else {
            for (item in ordenesFiltered) {
                if (item.orderType.toString().contains(text)) {
                    ordenes.add(item)
                    //Log.d(TAG, "pasty")

                }
            }
        }
        notifyDataSetChanged()
    }


    fun Deliveryfilter() {
        val text = "4"
        ordenes.clear()
        if (text.isEmpty()) {
            ordenes.addAll(ordenesFiltered)
        } else {
            for (item in ordenesFiltered) {
                if (item.orderType.toString().contains(text)) {
                    ordenes.add(item)
                    //Log.d(TAG, "pasty")

                }
            }
        }
        notifyDataSetChanged()
    }
}
