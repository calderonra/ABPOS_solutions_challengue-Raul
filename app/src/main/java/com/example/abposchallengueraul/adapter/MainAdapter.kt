package com.example.abposchallengueraul.adapter

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.abposchallengueraul.activities.OrdenesDetalleActivity
import com.example.abposchallengueraul.database.entity.Orden
import com.example.abposchallengueraul.databinding.OrdenesAdapterBinding

open class MainAdapter(val context: Context):RecyclerView.Adapter<MainAdapter.MainViewHolder> (){

     lateinit var sharedPreferences: SharedPreferences


    var ordenes= mutableListOf<Orden>()
    var ordenesFiltered= mutableListOf<Orden>()


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


  /*  override fun getFilter(): Filter {
        return object: Filter(){
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charString = p0?.toString() ?: ""
                if (charString.isEmpty())ordenesFiltered=ordenes else{
                    val filteredList=ArrayList<Orden>()
                    filteredList.filter {


                        (it.orderId.toString().contains(p0!!))

                    }
                        .forEach{ filteredList.add(it) }
                    ordenesFiltered=filteredList
                }
                return FilterResults().apply { values=ordenesFiltered}
            }

            override fun publishResults(p0: CharSequence?, results: FilterResults?) {
                ordenesFiltered=if (results?.values==null)
                    ArrayList()
                else
                    results.values as MutableList<Orden>
                notifyDataSetChanged()
            }

        }
    }*/
   fun filter(textAux: String) {
      val text = textAux
      ordenes.clear()
      if (text.isEmpty()) {
          ordenes.addAll(ordenesFiltered)
      } else {
          for (item in ordenesFiltered) {
              if (item.orderId.toString().contains(text)) {
                  ordenes.add(item)
                  Log.d(TAG, "pasty")

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
