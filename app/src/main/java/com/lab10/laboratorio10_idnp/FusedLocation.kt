package com.lab10.laboratorio10_idnp

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.gms.location.*

class FusedLocation : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var latitude: TextView
    private lateinit var longitude: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fused_location)

        latitude = findViewById(R.id.latitude)
        longitude = findViewById(R.id.longitude)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        val locationRequest = LocationRequest.create()
        locationRequest.interval = 0
        locationRequest.smallestDisplacement = 100.0f

        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED && ActivityCompat.
            checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return
        }

        fusedLocationProviderClient.requestLocationUpdates(locationRequest, object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                val location: Location? = locationResult.lastLocation
                if (location != null) {
                    latitude.text = Editable.Factory.getInstance().newEditable("Latitude: "+location.latitude)
                    longitude.text = Editable.Factory.getInstance().newEditable("Latitude: "+location.longitude)
                    Log.e("TAG",""+location.latitude+"\t"+location.longitude)
                }
            }
        }, null)

    }
}