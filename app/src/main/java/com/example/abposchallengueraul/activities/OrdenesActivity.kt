package com.example.abposchallengueraul.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.abposchallengueraul.R
import com.example.abposchallengueraul.adapter.MainAdapter
import com.example.abposchallengueraul.client.MainRepository
import com.example.abposchallengueraul.client.RetrofitService
import com.example.abposchallengueraul.databinding.ActivityOrdenesBinding
import com.example.abposchallengueraul.viewmodel.MainViewModel
import com.example.abposchallengueraul.viewmodel.MyViewModelFactory

class OrdenesActivity : AppCompatActivity() , SearchView.OnQueryTextListener{

    private val TAG = "OrdenesActivity"
    private lateinit var binding: ActivityOrdenesBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService=RetrofitService.getInstance()
    val adapter=MainAdapter(this)
    private lateinit var dineIn_btn: Button
    private lateinit var ToGO_btn: Button
    private lateinit var pickUp_btn: Button
    private lateinit var Delivery_btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordenes)
        binding= ActivityOrdenesBinding.inflate(layoutInflater)

        dineIn_btn=findViewById(R.id.DineInBtn)
        ToGO_btn=findViewById(R.id.togoBtn)
        pickUp_btn=findViewById(R.id.PickUpBtn)
        Delivery_btn=findViewById(R.id.DeliveryBtn)

        setContentView(binding.root)

        viewModel=ViewModelProvider(this,MyViewModelFactory(MainRepository(retrofitService))).get(MainViewModel::class.java)

        binding.recyclerview.adapter = adapter

        viewModel.ordenesList.observe(this, Observer {
            Log.d(TAG, "ordersList: $it")
            adapter.setOrdenesList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
            Log.d(TAG, "errorMessage: $it")
        })
        viewModel.getAllOrdenes()



        dineIn_btn.setOnClickListener {
            adapter.DineINfilter()
        }

        ToGO_btn.setOnClickListener {
            adapter.TogoFilter()
        }

        pickUp_btn.setOnClickListener {
            adapter.PickUPfilter()
        }

        Delivery_btn.setOnClickListener {
            adapter.Deliveryfilter()
        }

    }

    override fun onQueryTextSubmit(p0: String): Boolean {
        adapter.filter(p0)
        return true
    }

    override fun onQueryTextChange(p0: String): Boolean {
        adapter.filter(p0)
        return true
    }
}

