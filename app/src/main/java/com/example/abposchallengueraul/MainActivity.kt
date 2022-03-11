package com.example.abposchallengueraul

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.abposchallengueraul.activities.OrdenesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        goButton=findViewById(R.id.btnGo)

        goButton.setOnClickListener{

            val intent=Intent(this,OrdenesActivity::class.java)
            startActivity(intent)
        }

    }
}