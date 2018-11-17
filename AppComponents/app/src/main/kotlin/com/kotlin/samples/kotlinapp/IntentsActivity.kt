package com.kotlin.samples.kotlinapp

import android.app.Activity
import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_intents.*




class IntentsActivity : AppCompatActivity() {

    /**
     * https://developer.android.com/guide/components/intents-common?hl=es-419
     * https://android-developers.googleblog.com/2012/02/share-with-intents.html
     * https://developers.google.com/maps/documentation/urls/android-intents
     */
    private val REQUEST_IMAGE_GET=1
    val REQUEST_IMAGE_CAPTURE = 2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        //events
        button.setOnClickListener {
            showMessage("Hello Kotlin!")

            //openWebPage("https://www.google.com/")
            //dialPhoneNumber("947904631")
            //composeEmail()
            //val gmmIntentUri:Uri  = Uri.parse("geo:37.7749,-122.4192?q=" + Uri.encode("1st & Pike, Seattle"))
            //val gmmIntentUri:Uri  = Uri.parse("geo:-11.9917806,-77.0647037")
            //showMap(gmmIntentUri)
            //selectImage()
            openCamera()
        }
    }

    private fun showMessage(message:String?){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        Log.v("CONSOLE",message)
    }
    //common intents

    fun openWebPage(url: String) {
        val webpage = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun searchWeb(query: String) {
        val intent = Intent(Intent.ACTION_SEARCH)
        intent.putExtra(SearchManager.QUERY, query)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun composeEmail(addresses: Array<String>, subject: String, attachment: Uri) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_EMAIL, addresses)
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_STREAM, attachment)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun showMap(geoLocation: Uri) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = geoLocation
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun selectImage() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET)
        }
    }

    fun openCamera(){
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == Activity.RESULT_OK) {
            //Bitmap thumbnail = data.getParcelable("data");
            val fullPhotoUri = data?.data
            // Do work with photo saved at fullPhotoUri
            showMessage(fullPhotoUri?.toString())
        }else if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK){
            val fullPhotoUri = data?.data
            // Do work with photo saved at fullPhotoUri
            showMessage(fullPhotoUri?.toString())
        }
    }

}
