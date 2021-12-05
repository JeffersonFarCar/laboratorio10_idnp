package com.lab10.laboratorio10_idnp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.location_manager).setOnClickListener{
            val intent = Intent(this, LocationManager::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.fused_location).setOnClickListener{
            val intent = Intent(this, FusedLocation::class.java)
            startActivity(intent)
        }

    }
}