package com.kotlin.samples.kotlinapp.ui

import android.os.Bundle
import android.support.annotation.Nullable
import com.google.android.gms.maps.*
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.entity.Warike
import com.google.android.gms.maps.model.Marker
import org.jetbrains.annotations.NotNull
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.kotlin.samples.kotlinapp.model.storage.WarikeRepository


class PlaceMapActivity : BaseActivity(), OnMapReadyCallback,
GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {

    private var defaultLat:Double = -12.088915
    private var defaultLng:Double = -77.0365457//academia móviles-12.088915,-77.0365457

    @Nullable
    private var places: List<Warike> = emptyList()

    @NotNull
    private var warikeHashMap: MutableMap<Marker?, Warike> = mutableMapOf()

    private var googleMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_map)
        enabledBack()
        setUpGoogleMaps()
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
        //googleMap?.addMarker(MarkerOptions().position(LatLng(0.0, 0.0)).title("Marker"))
    }

    override fun onResume() {
        super.onResume()
        retrievePlaces()
    }

    private fun renderPlaces() {
        var marker: Marker? = null

        if(places.isEmpty()){
            googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(LatLng(defaultLat,defaultLng),10f))
        }else{
            val padding =20
            val builder:LatLngBounds.Builder  =  LatLngBounds.Builder()
            for (warike in places) {
                marker = buildMarker(warike)
                warikeHashMap[marker] = warike
                builder.include(LatLng(warike.lat,warike.lng))
            }
            val bounds:LatLngBounds  = builder.build()
            googleMap?.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds,padding))
        }
    }

    private fun buildMarker(warike: Warike): Marker? {
        val tmpLat = warike.lat
        val tmpLng = warike.lng
        val tmpTile = warike.name
        return googleMap?.addMarker(MarkerOptions().position(LatLng(tmpLat, tmpLng)).title(tmpTile))
    }
    //provider
    private fun retrievePlaces() {
        warikeRepository.getAllPlaces(object : WarikeRepository.QueryCallback {
            override fun onSuccess(mPlaces: List<Warike>) {
                places = mPlaces
                renderPlaces()
            }

            override fun onFailure(e: Exception) {}
        })
    }

    override fun onMarkerClick(marker: Marker): Boolean {
        //Warike warike= warikeHashMap.get(marker);
        //goToWarikeDetails(warike);
        // We return false to indicate that we have not consumed the event and that we wish
        // for the default behavior to occur (which is for the camera to move such that the
        // marker is centered and for the marker's info window to open, if it has one).
        return false
    }

    override fun onInfoWindowClick(marker: Marker) {
        val warike = warikeHashMap?.get(marker)
        goToWarikeDetails(warike)
    }

    private fun goToWarikeDetails(warike: Warike?) {
        val bundle = Bundle()
        bundle.putSerializable("WARIKE", warike)
        next(PlaceDetailsActivity::class.java, bundle, false)
    }
}
