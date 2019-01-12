package com.kotlin.samples.kotlinapp.ui

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.support.annotation.Nullable
import android.view.View
import com.kotlin.samples.kotlinapp.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_place_registration.*
import android.content.Intent
import android.content.pm.PackageManager

import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.provider.Settings
import android.support.design.widget.Snackbar
import com.kotlin.samples.kotlinapp.BuildConfig
import com.squareup.picasso.Picasso
import android.app.Activity
import java.io.File
import com.kotlin.samples.kotlinapp.model.entity.Warike


class PlaceRegistrationActivity : BaseActivity() {

    @Nullable
    private var currentPhotoPath: String? = null
    private val REQUEST_CAMERA = 1
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    /**
     * Provides the entry point to the Fused Location Provider API.
     */
    private var mFusedLocationClient: FusedLocationProviderClient? = null
    /**
     * Represents a geographical location.
     */
    protected var mLastLocation: Location? = null
    private var name: String? = null
    private var description: String? = null
    private var lat:Double = -12.088915
    private var lng:Double = -77.0365457//academia móviles-12.088915,-77.0365457

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_registration)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        ui()
    }

    private fun ui(){
        enabledBack()

        //events
        relativeLayout.setOnClickListener {
                takePhoto()
        }

        buttonRegister.setOnClickListener {
            if (validateForm()) {
                saveWarike()
            }
        }

        textViewLocation.setOnClickListener {
            val intent:Intent= Intent(this,LocationActivity::class.java)
            startActivityForResult(intent,200)
        }
        //ui states
        textViewMessage.visibility=View.VISIBLE
    }

    private fun validateForm(): Boolean {
        name = editTextName.text.toString()
        description = editTextDesc.text.toString()

        return true
    }

    private fun saveWarike() {

        val warike = Warike()
        warike.name = name
        warike.desc = description
        warike.lat=lat
        warike.lng=lng
        warike.photo = currentPhotoPath
        warike.rate = 5//Rate.MAX
        warikeRepository.addPlace(warike)

        showSnackbar(R.string.warike_successfully, android.R.string.ok,
                View.OnClickListener {
                    //close Activity
                    this@PlaceRegistrationActivity.finish()
                })
    }


    //camera methods
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("CONSOLE", "requestCode " + requestCode + " resultCode " + resultCode +
                " data " + data)
        if (requestCode == REQUEST_CAMERA) {
            if (resultCode == Activity.RESULT_OK) {
                textViewMessage.visibility = View.GONE
                if (data == null) return
                val bundle = data.extras
                if (bundle != null) {
                    currentPhotoPath = bundle.getString("PATH")
                    renderPhoto()
                }

            } else {
                textViewMessage.visibility = View.VISIBLE
            }
        }

        if(requestCode== 200){
            if (resultCode == Activity.RESULT_OK) {
                lat= data?.getDoubleExtra("USER_LAT",0.0)?:0.0
                lng= data?.getDoubleExtra("USER_LNG",0.0)?:0.0
                textViewLocation.text="Lat : $lat Lng : $lng"
            }
        }
    }

    private fun takePhoto() {
        startActivityForResult(Intent(this, CustomCameraActivity::class.java),
                REQUEST_CAMERA)
    }

    private fun renderPhoto() {
        currentPhotoPath?.let {
            Picasso.with(imageViewPhoto.context).load(File(it)).into(imageViewPhoto)
        }
    }

    //location
    public override fun onStart() {
        super.onStart()

        if (!checkPermissions()) {
            requestPermissions()
        } else {
            getLastLocation()
        }
    }

    /**
     * Provides a simple way of getting a device's location and is well suited for
     * applications that do not require a fine-grained location and that do not need location
     * updates. Gets the best and most recent location currently available, which may be null
     * in rare cases when a location is not available.
     *
     *
     * Note: this method should be called after location permission has been granted.
     */
    @SuppressLint("MissingPermission")
    private fun getLastLocation() {
        progress.visibility = View.VISIBLE
        //buttonRegister.setEnabled(false);
        mFusedLocationClient?.lastLocation?.addOnCompleteListener(this) { task ->
                    if (task.isSuccessful && task.result != null) {
                        mLastLocation = task.result

                        lat = mLastLocation?.latitude?:0.0
                        lng = mLastLocation?.longitude?:0.0
                        locationFoundSuccessfully()
                    } else {
                        Log.v("CONSOLE", "getLastLocation:exception ${task.exception.toString()}")
                        showSnackbar(getString(R.string.no_location_detected))
                        progress.visibility = View.GONE
                    }
                }
    }

    private fun locationFoundSuccessfully() {
        Log.v("CONSOLE", "lat $lat lng $lng")
        progress.visibility = View.GONE
        //buttonRegister.setEnabled(true);
    }

    /**
     * Shows a [Snackbar] using `text`.
     *
     * @param text The Snackbar text.
     */
    private fun showSnackbar(text: String) {
        val container = findViewById<View>(R.id.main_activity_container)
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show()
        }
    }

    /**
     * Shows a [Snackbar].
     *
     * @param mainTextStringId The id for the string resource for the Snackbar text.
     * @param actionStringId   The text of the action item.
     * @param listener         The listener associated with the Snackbar action.
     */
    private fun showSnackbar(mainTextStringId: Int, actionStringId: Int,
                             listener: View.OnClickListener) {
        Snackbar.make(findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show()
    }

    /**
     * Return the current state of the permissions needed.
     */
    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSIONS_REQUEST_CODE)
    }

    private fun requestPermissions() {
        val shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.ACCESS_FINE_LOCATION)

        // Provide an additional rationale to the user. This would happen if the user denied the
        // request previously, but didn't check the "Don't ask again" checkbox.
        if (shouldProvideRationale) {
            Log.i("CONSOLE", "Displaying permission rationale to provide additional context.")

            showSnackbar(R.string.permission_rationale, android.R.string.ok,
                    View.OnClickListener {
                        // Request permission
                        startLocationPermissionRequest()
                    })

        } else {
            Log.i("CONSOLE", "Requesting permission")
            // Request permission. It's possible this can be auto answered if device policy
            // sets the permission in a given state or the user denied the permission
            // previously and checked "Never ask again".
            startLocationPermissionRequest()
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>,
                                            grantResults: IntArray) {
        Log.i("CONSOLE", "onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                Log.i("CONSOLE", "User interaction was cancelled.")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
                getLastLocation()
            } else {
                // Permission denied.

                // Notify the user via a SnackBar that they have rejected a core permission for the
                // app, which makes the Activity useless. In a real app, core permissions would
                // typically be best requested during a welcome-screen flow.

                // Additionally, it is important to remember that a permission might have been
                // rejected without asking the user for permission (device policy or "Never ask
                // again" prompts). Therefore, a user interface affordance is typically implemented
                // when permissions are denied. Otherwise, your app could appear unresponsive to
                // touches or interactions which have required permissions.
                showSnackbar(R.string.permission_denied_explanation, R.string.settings,
                        View.OnClickListener {
                            // Build intent that displays the App settings screen.
                            val intent = Intent()
                            intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                            val uri = Uri.fromParts("package",
                                    BuildConfig.APPLICATION_ID, null)
                            intent.data = uri
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                            startActivity(intent)
                        })
            }
        }
    }
}
