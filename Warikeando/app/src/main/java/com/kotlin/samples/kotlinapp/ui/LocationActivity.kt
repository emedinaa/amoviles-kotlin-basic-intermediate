package com.kotlin.samples.kotlinapp.ui

import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.kotlin.samples.kotlinapp.R
import kotlinx.android.synthetic.main.activity_location.*
import android.app.Activity
import android.content.Intent
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions


class LocationActivity : BaseActivity(), OnMapReadyCallback,
        GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMapClickListener {

    private val defaultLat:Double = -12.088915
    private val defaultLng:Double = -77.0365457//academia móviles-12.088915,-77.0365457

    private var userLat:Double=0.0
    private var userLng:Double=0.0

    private var googleMap: GoogleMap?=null
    private var marker:Marker?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)
        enabledBack()
        setUpGoogleMaps()
        ui()
    }

    private fun setUpGoogleMaps() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map
        // We will provide our own zoom controls.
        googleMap?.uiSettings?.isZoomControlsEnabled = true
        googleMap?.uiSettings?.isMyLocationButtonEnabled = true
        googleMap?.setOnMarkerClickListener(this)
        googleMap?.setOnInfoWindowClickListener(this)
        googleMap?.setOnMapClickListener(this)
        marker= googleMap?.addMarker(MarkerOptions().position(LatLng(defaultLat, defaultLng)).title("Marker"))
        //googleMap?.addMarker(MarkerOptions().position(LatLng(0.0, 0.0)).title("Marker"))

        googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(defaultLat,defaultLng),15f))
    }

    private fun ui(){
        button.setOnClickListener {
            if(userLat!=0.0 && userLng!=0.0){
                sendLocation()
            }
        }
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        //Warike warike= warikeHashMap.get(marker);
        //goToWarikeDetails(warike);
        // We return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false
    }

    override fun onMapClick(selectedLatLng: LatLng?) {
        selectedLatLng?.let {
            googleMap?.clear()
            userLat= it.latitude
            userLng=it.longitude
            marker= googleMap?.addMarker(MarkerOptions().position(it))
        }
    }

    override fun onInfoWindowClick(marker: Marker) {}

    private fun sendLocation(){
        val intent = Intent()
        intent.putExtra("USER_LAT",userLat)
        intent.putExtra("USER_LNG",userLng)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
