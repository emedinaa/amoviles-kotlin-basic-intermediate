package com.kotlin.samples.kotlinapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.samples.kotlinapp.R
import com.kotlin.samples.kotlinapp.model.entity.Warike
import com.kotlin.samples.kotlinapp.R.string.warike
import kotlinx.android.synthetic.main.activity_place_details.*
import android.content.Intent
import android.net.Uri
import com.kotlin.samples.kotlinapp.R.string.warike
import com.squareup.picasso.Picasso
import java.io.File


class PlaceDetailsActivity : BaseActivity() {

    private var warike:Warike?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_details)
        extras()
        ui()
        populate()
    }

    private fun populate(){
        warike?.let {
            textViewName.text=it.name
            textViewDesc.text=it.desc
            Picasso.with(imageViewPhoto.context).load(
                    File(it.photo)).into(imageViewPhoto)
        }
    }
    private fun goToMap() {
        warike?:return
        //https://developers.google.com/maps/documentation/urls/android-intents

        // Creates an Intent that will load a map of San Francisco
        //Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
        val gmmIntentUri = Uri.parse("geo:" + warike?.lat + "," + warike?.lng + "?q=" +
                warike?.lat + "," + warike?.lng + "(" + warike?.name + ")")

        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }

    }

    private fun ui(){
        enabledBack()
        buttonMap.setOnClickListener {
            goToMap()
        }
    }

    private fun extras() {
        val bundle = intent?.extras
        bundle?.let {
            warike = (it.getSerializable("WARIKE") as Warike)
        }
    }
}
