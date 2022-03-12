package com.example.abposchallengueraul.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abposchallengueraul.activities.OrdenesDetalleActivity
import com.example.abposchallengueraul.database.entity.Orden
import com.example.abposchallengueraul.databinding.OrdenesAdapterBinding

class MainAdapter(val context: Context):RecyclerView.Adapter<MainAdapter.MainViewHolder> (){

     lateinit var sharedPreferences: SharedPreferences


    var ordenes= mutableListOf<Orden>()

    fun setOrdenesList(ordenes:List<Orden>){
        this.ordenes=ordenes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=OrdenesAdapterBinding.inflate(inflater,parent,false)

        sharedPreferences=context.getSharedPreferences("MySP", Activity.MODE_PRIVATE)

        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bin(ordenes[position])
    }

    override fun getItemCount(): Int {
        return ordenes.size
    }

    inner class MainViewHolder(val binding: OrdenesAdapterBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(ordenes: Orden){
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

}
