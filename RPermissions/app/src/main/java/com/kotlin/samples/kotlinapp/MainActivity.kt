package com.kotlin.samples.kotlinapp

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.content.Intent
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import com.kotlin.samples.kotlinapp.R


class MainActivity : AppCompatActivity(),ActivityCompat.OnRequestPermissionsResultCallback {

    private val PERMISSION_REQUEST_CAMERA = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCamera.setOnClickListener {
            showCameraPreview()
        }
    }

    private fun showCameraPreview(){
        // BEGIN_INCLUDE(startCamera)
        // Check if the Camera permission has been granted
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_GRANTED) {
            // Permission is already available, start camera preview
            Snackbar.make(mLayout,
                    R.string.camera_permission_available,
                    Snackbar.LENGTH_SHORT).show()
            startCamera()
        } else {
            // Permission is missing and must be requested.
            requestCameraPermission()
        }
        // END_INCLUDE(startCamera)
    }


    private fun requestCameraPermission() {
        // Permission has not been granted and must be requested.
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        Manifest.permission.CAMERA)) {
            // Provide an additional rationale to the user if the permission was not granted
            // and the user would benefit from additional context for the use of the permission.
            // Display a SnackBar with cda button to request the missing permission.
            Snackbar.make(mLayout, R.string.camera_access_required,
                    Snackbar.LENGTH_INDEFINITE).setAction(R.string.ok) {
                // Request the permission
                ActivityCompat.requestPermissions(this@MainActivity,
                        arrayOf(Manifest.permission.CAMERA),
                        PERMISSION_REQUEST_CAMERA)
            }.show()
        }else{
            Snackbar.make(mLayout, R.string.camera_unavailable, Snackbar.LENGTH_SHORT).show()
            // Request the permission. The result will be received in onRequestPermissionResult()
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.CAMERA),PERMISSION_REQUEST_CAMERA)
        }
    }

    private fun startCamera() {
        val intent = Intent(this, CameraPreviewActivity::class.java)
        startActivity(intent)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        // BEGIN_INCLUDE(onRequestPermissionsResult)
        if (requestCode == PERMISSION_REQUEST_CAMERA) {
            // Request for camera permission.
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission has been granted. Start camera preview Activity.
                Snackbar.make(mLayout, R.string.camera_permission_granted,
                        Snackbar.LENGTH_SHORT)
                        .show()
                startCamera()
            } else {
                // Permission request was denied.
                Snackbar.make(mLayout, R.string.camera_permission_denied,
                        Snackbar.LENGTH_SHORT)
                        .show()
            }
        }
        // END_INCLUDE(onRequestPermissionsResult)
    }
}
