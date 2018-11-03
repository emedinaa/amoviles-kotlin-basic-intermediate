package com.emedinaa.mykotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //events
        textView.setOnClickListener {
            //TODO
            showMessage()
        }
    }

    private fun showMessage() {
        Log.v("CONSOLE","Touch...")
        Toast.makeText(this, "Hello kotlin",
                Toast.LENGTH_LONG).show()
    }
}
