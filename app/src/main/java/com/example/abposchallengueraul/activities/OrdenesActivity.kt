package com.example.abposchallengueraul.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ordenes)
        binding= ActivityOrdenesBinding.inflate(layoutInflater)


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


    }

    override fun onQueryTextSubmit(p0: String?): Boolean {
        adapter.filter.filter(p0)
        return false
    }

    override fun onQueryTextChange(p0: String?): Boolean {
        adapter.filter.filter(p0)
        return false
    }
}

