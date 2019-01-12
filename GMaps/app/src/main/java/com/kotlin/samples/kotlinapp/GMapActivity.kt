package com.kotlin.samples.kotlinapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class GMapActivity : AppCompatActivity() ,OnMapReadyCallback{

    private var mMap:GoogleMap?=null
    val ZOOM_LEVEL = 13f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gmap)

        val mapFragment:SupportMapFragment= supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        mMap= googleMap

        val am= LatLng(-12.0890238,-77.0345461)
        //-12.0890238,-77.0345461,
        mMap?.addMarker(MarkerOptions().position(am).title("ACADEMIA MOVILES"))

        //mMap?.moveCamera(CameraUpdateFactory.newLatLng(am))
        mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(am,ZOOM_LEVEL))

    }
}
