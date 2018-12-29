package com.kotlin.samples.kotlinapp

import android.hardware.Camera
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.FrameLayout



/**
 * Displays a {@link CameraPreview} of the first {@link Camera}.
 * An error message is displayed if the Camera is not available.
 * <p>
 * This Activity is only used to illustrate that access to the Camera API has been granted (or
 * denied) as part of the runtime permissions model. It is not relevant for the use of the
 * permissions API.
 * <p>
 * Implementation is based directly on the documentation at
 * http://developer.android.com/guide/topics/media/camera.html
 */

class CameraPreviewActivity : AppCompatActivity() {

    /**
     * Id of the camera to access. 0 is the first camera.
     */
    private val CAMERA_ID = 0

    private var mCamera: Camera? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_camera_preview)

        // Open an instance of the first camera and retrieve its info.
        mCamera = getCameraInstance(CAMERA_ID)
        val cameraInfo = Camera.CameraInfo()
        Camera.getCameraInfo(CAMERA_ID, cameraInfo)

        if (mCamera == null) {
            // Camera is not available, display error message
            setContentView(R.layout.activity_camera_unavailable)
        } else {

            setContentView(R.layout.activity_camera)

            // Get the rotation of the screen to adjust the preview image accordingly.
            val displayRotation = windowManager.defaultDisplay.rotation

            // Create the Preview view and set it as the content of this Activity.
            val cameraPreview = CameraPreview(this, null,
                    0, mCamera, cameraInfo, displayRotation)
            val preview = findViewById<FrameLayout>(R.id.camera_preview)
            preview.addView(cameraPreview)
        }
    }


    public override fun onPause() {
        super.onPause()
        // Stop camera access
        releaseCamera()
    }

    /**
     * A safe way to get an instance of the Camera object.
     */
    private fun getCameraInstance(cameraId: Int): Camera? {
        var c: Camera? = null
        try {
            c = Camera.open(cameraId) // attempt to get a Camera instance
        } catch (e: Exception) {
            // Camera is not available (in use or does not exist)
            Log.e("CONSOLE", "Camera " + cameraId + " is not available: " + e.message)
        }

        return c // returns null if camera is unavailable
    }

    /**
     * Release the camera for other applications.
     */
    private fun releaseCamera() {
        mCamera?.let {
            it.release()
            mCamera = null
        }
    }

}
