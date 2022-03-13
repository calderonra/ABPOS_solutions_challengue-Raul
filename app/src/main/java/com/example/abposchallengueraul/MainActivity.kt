package com.example.abposchallengueraul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.abposchallengueraul.activities.OrdenesActivity
import com.example.abposchallengueraul.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnGo.setOnClickListener{

            val intent=Intent(this,OrdenesActivity::class.java)
            startActivity(intent)
        }
        binding.btnOne.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "1"
        }
        binding.btnTwo.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "2"
        }
        binding.btnThree.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "3"
        }
        binding.btnFour.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "4"
        }
        binding.btnFive.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "5"
        }
        binding.btnSix.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "6"
        }
        binding.btnSeven.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "7"
        }
        binding.btnEight.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "8"
        }
        binding.btnNine.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "9"
        }
        binding.btnZero.setOnClickListener {
            binding.txtInput.text = binding.txtInput.text.toString() + "0"
        }
        binding.btnClear.setOnClickListener {
            binding.txtInput.text = ""
        }
    }
}