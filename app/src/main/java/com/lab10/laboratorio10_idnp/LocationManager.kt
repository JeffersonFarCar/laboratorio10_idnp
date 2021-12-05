package com.lab10.laboratorio10_idnp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.TextView
import androidx.core.app.ActivityCompat

class LocationManager : AppCompatActivity(), LocationListener {

    private lateinit var locationManager: LocationManager
    private lateinit var latitude: TextView
    private lateinit var longitude: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_manager)

        latitude = findViewById(R.id.latitude)
        longitude = findViewById(R.id.longitude)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager


        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 100.0f, this)

    }

    override fun onLocationChanged(p0: Location) {

        latitude.text = Editable.Factory.getInstance().newEditable("Latitude: "+p0.latitude)
        longitude.text = Editable.Factory.getInstance().newEditable("Longitude: "+p0.longitude)

        //locationManager.removeUpdates(this)

        Log.e("TAG", ""+latitude.text+"\t"+longitude.text)

    }

}