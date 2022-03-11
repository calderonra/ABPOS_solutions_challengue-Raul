package com.example.abposchallengueraul.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abposchallengueraul.database.entity.Orden
import com.example.abposchallengueraul.databinding.OrdenesAdapterBinding

class MainAdapter:RecyclerView.Adapter<MainViewHolder> (){

var ordenes= mutableListOf<Orden>()

    fun setOrdenesList(ordenes:List<Orden>){
        this.ordenes=ordenes.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=OrdenesAdapterBinding.inflate(inflater,parent,false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val orden=ordenes[position]
        holder.binding.orderTV.text=orden.id.toString()
        holder.binding.ticketTV.text=orden.ticketNumber.toString()
        holder.binding.PickUpTV.text=orden.orderType.toString()
        holder.binding.orderTimeTV.text=orden.orderDateTime

    }

    override fun getItemCount(): Int {
        return ordenes.size
    }
}
class MainViewHolder(val binding: OrdenesAdapterBinding):RecyclerView.ViewHolder(binding.root){

}
