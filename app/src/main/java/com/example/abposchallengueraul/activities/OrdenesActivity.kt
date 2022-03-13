package com.example.abposchallengueraul.activities

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.abposchallengueraul.adapter.MainAdapter
import com.example.abposchallengueraul.client.MainRepository
import com.example.abposchallengueraul.client.RetrofitService
import com.example.abposchallengueraul.database.entity.Orden
import com.example.abposchallengueraul.databinding.ActivityOrdenesBinding
import com.example.abposchallengueraul.viewmodel.MainViewModel
import com.example.abposchallengueraul.viewmodel.MyViewModelFactory

class OrdenesActivity : AppCompatActivity(){

    private val TAG = "OrdenesActivity"

    private var ordenes:MutableList<Orden> = mutableListOf()
    private lateinit var binding: ActivityOrdenesBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService=RetrofitService.getInstance()
    private var adapter: MainAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrdenesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ordenes = ArrayList()
        adapter = MainAdapter(this, ordenes)

        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(newText: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                if (newText.isEmpty() && adapter != null) {
                    adapter!!.filter("")
                }
                if (!newText.isEmpty() && adapter != null) {
                    adapter!!.filter(newText)
                }
                return true
            }
        })



        val linearLayout = LinearLayoutManager(this)

        binding.recyclerview.layoutManager = linearLayout
        binding.recyclerview.adapter = adapter

        viewModel=ViewModelProvider(this,MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)
        viewModel.getAllOrdenes()

        viewModel.ordenesList.observe(this, Observer {
            ordenes.addAll(it)
            Log.d(TAG, "ordersList: $it")
            ordenes.forEach {
                Log.e("avr", it.orderId.toString())
            }
            adapter!!.notifyDataSetChanged()
        })




        //binding.searchView.setOnQueryTextListener(this)
        binding.searchView.isIconified = true
        binding.searchView.clearFocus()
        binding.searchView.queryHint = "Buscar..."

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })



        binding.DineInBtn.setOnClickListener {
            adapter!!.DineINfilter()
        }

        binding.DineInBtn.setOnClickListener {
            adapter!!.TogoFilter()
        }

        binding.DineInBtn.setOnClickListener {
            adapter!!.PickUPfilter()
        }

        binding.DineInBtn.setOnClickListener {
            adapter!!.Deliveryfilter()
        }

    }

}

