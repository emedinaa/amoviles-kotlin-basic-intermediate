package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_basic_events.*


class BasicEventsActivity : AppCompatActivity() {

    private var message:String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_events)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn.setOnClickListener {
            message= "BUTTON"
            showMessage(message)
        }

        ivi.setOnClickListener {
            message= "IMAGEVIEW"
            showMessage(message)
        }

        flay.setOnClickListener {
            message= "FRAMELAYOUT"
            showMessage(message)
        }


        tvi.setOnClickListener {
            message= "TEXTVIEW"
            showMessage(message)
        }
    }

    private fun showMessage(msg: String?) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
